package br.com.tratamentovip.core.business.services;

import br.com.tratamentovip.core.persistence.model.Usuario;

public interface LoginService {
	
	public Usuario autentica(String login, String senha);
	
}
