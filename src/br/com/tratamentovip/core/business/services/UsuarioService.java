package br.com.tratamentovip.core.business.services;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.Cliente;
import br.com.tratamentovip.core.persistence.model.Usuario;


public interface UsuarioService {
	
	public List<Usuario> getAllUsers();
	
	public Usuario getUsuarioPk(Integer pk);
	
	public void cadastra(Usuario usuario);
	
	public void atualiza(Usuario usuario);
	
	public void exclui(Usuario usuario);
	
	public void cadastra(Cliente cliente);
	
}
