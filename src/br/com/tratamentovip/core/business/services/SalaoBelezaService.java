package br.com.tratamentovip.core.business.services;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.Especialidade;
import br.com.tratamentovip.core.persistence.model.SalaoBeleza;

public interface SalaoBelezaService {
	
	public void cadastrar(SalaoBeleza salaoBeleza);
	
	public SalaoBeleza consulta(String nome);
	
	public List<SalaoBeleza> consultarSalao(String regiao);
	
	public List<SalaoBeleza> consultarSalao(String regiao, String bairro);
	
	public SalaoBeleza consultarSalao(Integer pk);
	
	public List<SalaoBeleza> listarTodos();
	
	public void inserir(SalaoBeleza salaoBeleza);
	
	public List<SalaoBeleza> getSalaoRegiao(String regiao);
	
}
