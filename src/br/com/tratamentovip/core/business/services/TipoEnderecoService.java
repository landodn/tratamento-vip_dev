package br.com.tratamentovip.core.business.services;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.TipoEndereco;

public interface TipoEnderecoService {
	
	public void inserir(TipoEndereco tipoEndereco);
	
	public void alterar(TipoEndereco tipoEndereco);
	
	public void excluir(TipoEndereco tipoEndereco);
	
	public List<TipoEndereco> listarTodos();
	
	public TipoEndereco buscaPorPk(Integer pk);
	
}
