package br.com.tratamentovip.core.business.services;

import br.com.tratamentovip.core.persistence.model.Cliente;
import br.com.tratamentovip.core.persistence.model.SalaoBeleza;

public interface LoginAuthService {
	
	public SalaoBeleza getLoginSalao(String usuario, String senha);
	
	public Cliente getLoginCliente(String usuario, String senha);

}
