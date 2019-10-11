package br.com.tratamentovip.core.persistence.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tratamentovip.core.persistence.model.Cliente;
import br.com.tratamentovip.core.persistence.repository.ClienteDAO;

@Repository("clienteDAO")
@Transactional
public class ClienteDAOImpl extends AbstractDAOImpl<Cliente, Integer> implements ClienteDAO{

	public List<Cliente> listarTodos(){
		return super.findAll();
	}
	
	public Cliente buscaPorPk(Integer pk){
		return findById(pk, false);
	}
	
	public void inserir(Cliente cliente){
		super.persist(cliente);
	}
	
	public void alterar(Cliente cliente){
		super.update(cliente);
	}
	
	public void excluir(Integer pk){
		super.delete(pk);
	}
	
}
