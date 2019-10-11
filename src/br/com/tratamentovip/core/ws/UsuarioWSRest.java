package br.com.tratamentovip.core.ws;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tratamentovip.core.business.services.LoginAuthService;
import br.com.tratamentovip.core.business.services.UsuarioService;
import br.com.tratamentovip.core.persistence.model.Cliente;
import br.com.tratamentovip.core.persistence.model.Endereco;
import br.com.tratamentovip.core.persistence.model.Telefone;
import br.com.tratamentovip.core.persistence.model.TipoEndereco;
import br.com.tratamentovip.core.persistence.model.TipoTelefone;
import br.com.tratamentovip.core.persistence.model.TipoUsuario;
import br.com.tratamentovip.core.persistence.model.Usuario;

@Path("/usuario")
@Component
public class UsuarioWSRest {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private LoginAuthService loginService;
	
	/**
	 * @param usuarioService the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	
	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginAuthService loginService) {
		this.loginService = loginService;
	}


	@GET
	@Path("/{usuario}/{senha}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente getUsuarioSalao(@PathParam("usuario") String usuario, @PathParam("senha") String senha){
		
			Cliente usuarioSalao = loginService.getLoginCliente(usuario, senha);
			
			return usuarioSalao;
		
	}
	
	@GET
	@Path("/id/{pk}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUserById(@PathParam("pk") Integer pk){
		return usuarioService.getUsuarioPk(pk);
	}
	
	
	@PUT
	@Path("/put")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Cliente cliente){
		try{
			if(cliente != null){
				cliente.setDataCadastro(new Date());
				TipoUsuario tipo = new TipoUsuario();
				tipo.setId(4);
				cliente.setTipoUsuario(tipo);
				
				Endereco endereco = cliente.getEndereco();
				if(endereco != null){
					TipoEndereco tipoEndereco = new TipoEndereco();
					tipoEndereco.setId(1);
					endereco.setTipoEndereco(tipoEndereco);
				}
				Telefone telefone = cliente.getTelefone();
				if(telefone != null){
					TipoTelefone tipoTelefone = new TipoTelefone();
					tipoTelefone.setId(1);
					telefone.setTipoTelefone(tipoTelefone);
				}
			}
			usuarioService.cadastra(cliente);
		}catch(Exception ex){
			return Response.status(500).entity(cliente).build();
		}
		return Response.status(201).entity(cliente).build();
	}
	
}
