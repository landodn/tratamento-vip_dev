package br.com.tratamentovip.core.persistence.repository;

import br.com.tratamentovip.core.persistence.model.SalaoBeleza;

public interface LoginSalaoAuthDAO extends DAO<SalaoBeleza, Integer>{
	
	public SalaoBeleza getLoginSalao(String usuario, String senha);
	
}
