package br.com.tratamentovip.core.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tratamentovip.core.business.services.UsuarioService;
import br.com.tratamentovip.core.persistence.model.Cliente;
import br.com.tratamentovip.core.persistence.model.Usuario;
import br.com.tratamentovip.core.persistence.repository.UsuarioDAO;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioDAO usuarioDAO){
		this.usuarioDAO = usuarioDAO;
	}
	
	/**
	 * Retorna todos os usuarios sem restricao
	 */
	public List<Usuario> getAllUsers(){
		return usuarioDAO.findAll();
	}
	
	/**
	 * Retorna um usuario especifico, de acordo com o ID informado
	 */
	public Usuario getUsuarioPk(Integer pk){
		return  usuarioDAO.findById(pk, false);
	}
	
	public void cadastra(Usuario usuario){
		usuarioDAO.cadastra(usuario);
	}
	
	public void atualiza(Usuario usuario){
		usuarioDAO.altera(usuario);
	}
	
	public void exclui(Usuario usuario){
		usuarioDAO.exclui(usuario.getId());
	}
	
	public void cadastra(Cliente cliente){
		usuarioDAO.cadastra(cliente);
	}
	
}
