package br.com.tratamentovip.core.persistence.repository.impl;

import java.util.List;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.tratamentovip.core.persistence.model.SalaoBeleza;
import br.com.tratamentovip.core.persistence.repository.SalaoBelezaDAO;
import br.com.tratamentovip.core.persistence.repository.mapper.SalaoBelezaRowMapper;

@Repository("salaoBelezaDAO")
@Transactional
public class SalaoBelezaDAOImpl extends AbstractDAOImpl<SalaoBeleza, Integer> implements SalaoBelezaDAO{

	public void cadastrar(SalaoBeleza salaoBeleza){
		super.update(salaoBeleza);
	}
	
	public List<SalaoBeleza> listarTodos(){
		return findAll();
	}
	
	public void inserir(SalaoBeleza salaoBeleza){
		super.update(salaoBeleza);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<SalaoBeleza> buscaSalaoRaio(String longitude, String latitude){
		
		List<SalaoBeleza> salaoBeleza = createCriteria()
				.add(Restrictions.eq("longitude", longitude))
				.add(Restrictions.eq("latitude", latitude))
				.list();
		
		return salaoBeleza;
				
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<SalaoBeleza> consultarSalao(String regiao){
				
		String query = " select facebook,cpf_Cnpj,horario_Abertura,horario_Fechamento,nome_Fantasia,razao_Social from Salao_Beleza s, Endereco e where s.id_endereco = e.id_endereco and e.regiao like ? ";
		
		List<SalaoBeleza> list = getJdbcTemplate().query(query,  new Object[] {"%"+regiao+"%"}, new SalaoBelezaRowMapper() );
				
		return list;
		
		
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<SalaoBeleza> consultarSalao(String regiao, String bairro){
		
		String query = "select facebook,cpf_Cnpj,horario_Abertura,horario_Fechamento,nome_Fantasia,razao_Social from Salao_Beleza s, Endereco e where s.id_endereco = e.id_endereco and e.regiao like ? and e.bairro like ? ";
		
		List<SalaoBeleza> list = getJdbcTemplate().query(query,  new Object[] {"%"+regiao+"%","%"+bairro+"%"}, new SalaoBelezaRowMapper() );
				
		return list;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public SalaoBeleza consultarSalao(Integer pk){
		
		String query = "select facebook,cpf_Cnpj,horario_Abertura,horario_Fechamento,nome_Fantasia,razao_Social from Salao_Beleza s where s.id = ? ";
		
		SalaoBeleza sal = getJdbcTemplate().queryForObject(query,  new Object[] {pk}, new SalaoBelezaRowMapper() );
				
		return sal;
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public SalaoBeleza buscaSalaoRaio2(String longitude, String latitude){
		return (SalaoBeleza) createCriteria()
				.add(Restrictions.eq("longitude", longitude))
				.add(Restrictions.eq("latitude", latitude))
				.list();
				
	}
	
	public List<SalaoBeleza> getSalaoBelezaRegiao(Integer regiao){
		Root<SalaoBeleza> root = super.getCriteria().from(SalaoBeleza.class);
		super.getCriteria().select(root);
		Predicate pRegiao = cb.equal(root.get("regiao"), regiao);
		super.getCriteria().where(pRegiao);
		return null;
	}

}