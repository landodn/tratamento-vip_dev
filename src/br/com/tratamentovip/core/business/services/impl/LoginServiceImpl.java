package br.com.tratamentovip.core.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tratamentovip.core.business.services.LoginService;
import br.com.tratamentovip.core.persistence.model.Usuario;
import br.com.tratamentovip.core.persistence.repository.UsuarioDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	UsuarioDAO usuarioDAO;
	
	@Autowired
	public LoginServiceImpl(UsuarioDAO usuarioDAO){
		this.usuarioDAO = usuarioDAO;
	}
	
	public Usuario autentica(String login, String senha){
		Usuario usuario = usuarioDAO.autentica(login, senha);
		return usuario;
	}
}
