package br.com.tratamentovip.core.persistence.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.tratamentovip.core.persistence.model.Especialidade;
import br.com.tratamentovip.core.persistence.repository.EspecialidadeDAO;
import br.com.tratamentovip.core.persistence.repository.mapper.EspecialidadeRowMapper;

@Repository("especialidadeDAO")
@Transactional
public class EspecialidadeDAOImpl extends AbstractDAOImpl<Especialidade, Integer> implements EspecialidadeDAO{

	
	public List<Especialidade> listarTodos(){
		return super.findAll();
	}
	
	public Especialidade buscaPorPk(Integer pk){
		return findById(pk, false);
	}
	
	public void inserir(Especialidade especialidade){
		super.persist(especialidade);
	}
	
	public void alterar(Especialidade especialidade){
		super.update(especialidade);
	}
	
	public void excluir(Integer pk){
		super.delete(pk);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Especialidade> consultarEspecialidadeSalao(Integer idSalao){
		String query = "select e.id, e.descricao from especialidade e , salao_beleza b, especialidade_salao es where e.id = es.id_especialidade and b.id = es.id and b.id = ?";
		
		List<Especialidade> list = getJdbcTemplate().query(query,  new Object[] {idSalao}, new EspecialidadeRowMapper() );
				
		return list;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Especialidade> exemplo() {
		
				
		String query = "select e.id, e.descricao from especialidade e , salao_beleza b, especialidade_salao es where e.id = es.id_especialidade and b.id = es.id and b.id = ?";
		
	
	List<Especialidade> list = getJdbcTemplate().query(query,  new Object[] {}, new RowMapper<Especialidade>() {
        public Especialidade mapRow(ResultSet rs, int rowNum) throws SQLException {
            Especialidade esp = new Especialidade();
            esp.setId(rs.getInt("id"));
            esp.setDescricao(rs.getString("descricao"));
            return esp;
        }
    });
	
	
	
	
		
		return list;
	}
	
}
