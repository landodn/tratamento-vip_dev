package br.com.tratamentovip.core.persistence.repository;

import br.com.tratamentovip.core.persistence.model.Cliente;
import br.com.tratamentovip.core.persistence.model.Usuario;

public interface UsuarioDAO extends DAO<Usuario, Integer> {
	
	public Usuario autentica(String usuario, String senha);
	
	public void cadastra(Usuario usuario);
	
	public Usuario consulta(Integer pk);
	
	public void altera(Usuario usuario);
	
	public void exclui(Integer pk);
	
	public void cadastra(Cliente cliente);
}
