package br.com.tratamentovip.core.business.services;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.Especialidade;

public interface EspecialidadeService {
	
	public List<Especialidade> listarTodos();
	
	public Especialidade buscaPorPk(Integer pk);
	
	public void inserir(Especialidade especialidade);
	
	public void excluir(Especialidade especialidade);
	
	public void alterar(Especialidade especialidade);
	
	public List<Especialidade> consultarEspecialidadeSalao(Integer idSalao);
	
}
