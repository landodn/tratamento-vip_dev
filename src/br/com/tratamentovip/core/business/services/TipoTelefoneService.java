package br.com.tratamentovip.core.business.services;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.TipoTelefone;

public interface TipoTelefoneService {
	
	public void inserir(TipoTelefone tipoTelefone);
	
	public void alterar(TipoTelefone tipoTelefone);
	
	public void excluir(TipoTelefone tipoTelefone);
	
	public List<TipoTelefone> listarTodos();
	
	public TipoTelefone buscaPorPk(Integer pk);
	
}
