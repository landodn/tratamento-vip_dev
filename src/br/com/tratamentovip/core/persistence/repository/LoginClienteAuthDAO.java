package br.com.tratamentovip.core.persistence.repository;

import br.com.tratamentovip.core.persistence.model.Cliente;

public interface LoginClienteAuthDAO extends DAO<Cliente, Integer>{
	
	public Cliente getLoginCliente(String usuario, String senha);
	
}
