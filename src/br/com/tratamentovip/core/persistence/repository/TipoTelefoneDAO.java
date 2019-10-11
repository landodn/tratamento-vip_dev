package br.com.tratamentovip.core.persistence.repository;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.TipoTelefone;

public interface TipoTelefoneDAO extends DAO<TipoTelefone, Integer>{
	
	public void inserir(TipoTelefone tipoTelefone);
	
	public void alterar(TipoTelefone tipoTelefone);
	
	public void excluir(Integer pk);
	
	public List<TipoTelefone> listarTodos();
	
	public TipoTelefone buscaPorPk(Integer pk);
	
}
