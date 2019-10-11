package br.com.tratamentovip.core.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tratamentovip.core.business.services.ClienteService;
import br.com.tratamentovip.core.persistence.model.Cliente;
import br.com.tratamentovip.core.persistence.repository.ClienteDAO;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService{
	
	private ClienteDAO clienteDAO;
	
	@Autowired
	public ClienteServiceImpl(ClienteDAO clienteDAO){
		this.clienteDAO = clienteDAO;
	}
	
	public List<Cliente> listarTodos(){
		return clienteDAO.listarTodos();
	}
	
	public void inserir(Cliente cliente){
		clienteDAO.inserir(cliente);
	}
	
	public Cliente buscaPorPk(Integer pk){
		return clienteDAO.buscaPorPk(pk);
	}
	
	public void excluir(Cliente cliente){
		clienteDAO.excluir(cliente.getId());
	}
	
	public void alterar(Cliente cliente){
		clienteDAO.alterar(cliente);
	}
	
}
