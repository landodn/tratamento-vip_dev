package br.com.tratamentovip.core.persistence.repository;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.TipoEndereco;

public interface TipoEnderecoDAO extends DAO<TipoEndereco, Integer>{

	public void inserir(TipoEndereco tipoEndereco);
	
	public void alterar(TipoEndereco tipoEndereco);
	
	public void excluir(Integer pk);
	
	public List<TipoEndereco> listarTodos();
	
	public TipoEndereco buscaPorPk(Integer pk);
	
}
