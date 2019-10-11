package br.com.tratamentovip.core.persistence.repository;

import java.util.List;
import java.util.Map;

import br.com.tratamentovip.core.persistence.model.Especialidade;
import br.com.tratamentovip.core.persistence.model.Profissional;
import br.com.tratamentovip.core.persistence.model.SalaoBeleza;

public interface EspecialidadeDAO extends DAO<Especialidade, Integer>{
	
	public List<Especialidade> listarTodos();
	
	public Especialidade buscaPorPk(Integer pk);
	
	public void inserir(Especialidade especialidade);
	
	public void excluir(Integer pk);
	
	public void alterar(Especialidade especialidade);	
	
	public List<Especialidade> consultarEspecialidadeSalao(Integer idSalao);
	
	public List<Especialidade> exemplo();
	
}
