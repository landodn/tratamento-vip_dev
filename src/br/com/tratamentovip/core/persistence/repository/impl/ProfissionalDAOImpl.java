package br.com.tratamentovip.core.persistence.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.tratamentovip.core.persistence.model.Profissional;
import br.com.tratamentovip.core.persistence.repository.ProfissionalDAO;
import br.com.tratamentovip.core.persistence.repository.mapper.ProfissionalRowMapper;

@Repository("profissionalDao")
@Transactional
public class ProfissionalDAOImpl extends AbstractDAOImpl<Profissional, Integer> implements ProfissionalDAO{
	
	
	public void cadastra(Profissional profissional){
		persist(profissional);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Profissional consulta(Integer pk){
		return findById(pk, false);
	}
	
	public void altera(Profissional profissional){
		update(profissional);
	}
	
	public void exclui(Integer pk){
		delete(pk);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Profissional> getProfissionalPorSalaoEspecialidade(
			Integer idSalaoBeleza, Integer idEspecialidade, String teste) { 
		TypedQuery<Profissional> query = super.getEntityManager().createQuery("select p from Profissional p INNER JOIN p.profissionalEspecialidade pe WHERE pe.id = :id_especialidade AND p.profissionalSalaoBeleza.id = :id_salao", super.getPersistentClass());
		query.setParameter("id_especialidade", idEspecialidade);
		query.setParameter("id_salao", idSalaoBeleza);
		return query.getResultList();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Profissional> getProfissionalPorSalaoEspecialidade(
			Integer idSalaoBeleza, Integer idEspecialidade) { 
		
		String query  = "select p.id, p.nome from Profissional as p inner join profissional_especialidade as ep ON (p.id = ep.id) WHERE ep.id_especialidade = ? AND p.id_salao = ?";
		
		List<Profissional> list = getJdbcTemplate().query(query,  new Object[] {idSalaoBeleza,idEspecialidade}, new ProfissionalRowMapper()); 

		return list;
	}
}
