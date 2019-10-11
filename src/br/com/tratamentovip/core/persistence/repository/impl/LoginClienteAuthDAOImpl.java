package br.com.tratamentovip.core.persistence.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.tratamentovip.core.persistence.model.Cliente;
import br.com.tratamentovip.core.persistence.repository.LoginClienteAuthDAO;
import br.com.tratamentovip.core.persistence.repository.mapper.ClienteRowMapper;

@Repository
@Transactional
public class LoginClienteAuthDAOImpl extends AbstractDAOImpl<Cliente, Integer> implements LoginClienteAuthDAO{
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Cliente getLoginCliente(String usuario, String senha){
				
		String query = "select data_nascimento,facebook,nome,c.id from cliente c, usuario u where u.id = c.id and u.login_email = ? and senha = ? ";
		
		Cliente cliente = getJdbcTemplate().queryForObject(query,  new Object[] {usuario,senha}, new ClienteRowMapper() );
				
		return cliente;
	}
	
}
