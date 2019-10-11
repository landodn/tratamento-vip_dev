package br.com.tratamentovip.core.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tratamentovip.core.business.services.LoginAuthService;
import br.com.tratamentovip.core.persistence.model.Cliente;
import br.com.tratamentovip.core.persistence.model.SalaoBeleza;
import br.com.tratamentovip.core.persistence.repository.LoginClienteAuthDAO;
import br.com.tratamentovip.core.persistence.repository.LoginSalaoAuthDAO;

@Service
public class LoginAuthServiceImpl implements LoginAuthService{
	
	private LoginSalaoAuthDAO salaoAuthDAO;
	
	private LoginClienteAuthDAO clienteAuthDAO;
	
	@Autowired
	public LoginAuthServiceImpl(LoginSalaoAuthDAO salaoAuthDAO, LoginClienteAuthDAO clienteAuthDAO){
		this.salaoAuthDAO = salaoAuthDAO;
		this.clienteAuthDAO = clienteAuthDAO;
	}
	
	public Cliente getLoginCliente(String usuario, String senha){
		return clienteAuthDAO.getLoginCliente(usuario, senha);
	}
	
	public SalaoBeleza getLoginSalao(String usuario, String senha){
		return salaoAuthDAO.getLoginSalao(usuario, senha);
	}
	
}
