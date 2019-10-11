package br.com.tratamentovip.core.business.services;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.Cliente;

public interface ClienteService {
	
	public List<Cliente> listarTodos();
	
	public Cliente buscaPorPk(Integer pk);
	
	public void inserir(Cliente cliente);
	
	public void excluir(Cliente cliente);
	
	public void alterar(Cliente cliente);
	
}
