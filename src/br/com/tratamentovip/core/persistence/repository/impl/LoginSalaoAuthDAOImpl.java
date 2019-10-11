package br.com.tratamentovip.core.persistence.repository.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tratamentovip.core.persistence.model.SalaoBeleza;
import br.com.tratamentovip.core.persistence.repository.LoginSalaoAuthDAO;

@Repository
@Transactional
public class LoginSalaoAuthDAOImpl extends AbstractDAOImpl<SalaoBeleza, Integer> implements LoginSalaoAuthDAO{
	
	public SalaoBeleza getLoginSalao(String usuario, String senha){
		return (SalaoBeleza) createCriteria()
					.add(Restrictions.eq("login", usuario))
					.add(Restrictions.eq("senha", senha))
					.uniqueResult();
	}
	
}
