package br.com.tratamentovip.core.persistence.repository;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.Especialidade;
import br.com.tratamentovip.core.persistence.model.SalaoBeleza;

public interface SalaoBelezaDAO extends DAO<SalaoBeleza, Integer>{
	
	public void cadastrar(SalaoBeleza salaoBeleza);
	
	public List<SalaoBeleza> listarTodos();
	
	public List<SalaoBeleza> consultarSalao(String regiao);
	
	public List<SalaoBeleza> consultarSalao(String regiao, String bairro);
	
	public SalaoBeleza consultarSalao(Integer pk);
	
	public void inserir(SalaoBeleza salaoBeleza);
	
	public List<SalaoBeleza>  buscaSalaoRaio(String longitude, String latitude);
	
	
}
