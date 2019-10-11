package br.com.tratamentovip.core.persistence.repository.impl;

import javax.persistence.Query;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.tratamentovip.core.persistence.model.Cliente;
import br.com.tratamentovip.core.persistence.model.Usuario;
import br.com.tratamentovip.core.persistence.repository.UsuarioDAO;

@Repository("usuarioDao")
@Transactional
public class UsuarioDAOImpl extends AbstractDAOImpl<Usuario, Integer> implements UsuarioDAO{
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Usuario autentica(String login, String senha){
		return (Usuario) createCriteria()
				.add(Restrictions.eq("loginEmail", login))
				.add(Restrictions.eq("senha", senha))
				.uniqueResult();

	}
	
	public void cadastra(Usuario usuario){
		persist(usuario);
	}
	
	public void consultar(){
		Query query = super.getEntityManager().createNativeQuery("", super.getPersistentClass());
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Usuario consulta(Integer pk){
		return findById(pk, false);
	}
	
	public void altera(Usuario usuario){
		update(usuario);
	}
	
	public void exclui(Integer pk){
		delete(pk);
	}
	
	public void cadastra(Cliente cliente){
		super.update(cliente);
//		persist(cliente);
	}
}
