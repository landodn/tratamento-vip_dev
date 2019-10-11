package br.com.tratamentovip.core.web.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.tratamentovip.core.persistence.model.Usuario;

@Controller
@Scope("session")
public class UsuarioSessao implements Serializable{
	
	private static final long serialVersionUID = 4833741323242320333L;

	private Usuario usuario;
	
	public void login(Usuario usuario) {
		this.usuario = usuario;
	}

	public void logout() {
		this.usuario = null;
	}
	
	public boolean isLogado() {
		return this.usuario != null;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
}
