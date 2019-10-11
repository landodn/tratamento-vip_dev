package br.com.tratamentovip.core.persistence.repository;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.Cliente;

public interface ClienteDAO extends DAO<Cliente, Integer>{
	
	public List<Cliente> listarTodos();
	
	public Cliente buscaPorPk(Integer pk);
	
	public void inserir(Cliente especialidade);
	
	public void excluir(Integer pk);
	
	public void alterar(Cliente especialidade);
	
}
