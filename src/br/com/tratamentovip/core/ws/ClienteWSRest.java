package br.com.tratamentovip.core.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tratamentovip.core.business.services.ClienteService;
import br.com.tratamentovip.core.persistence.model.Cliente;


@Path("/cliente")
@Component
public class ClienteWSRest {
	
	@Autowired
	private ClienteService clienteService;
	
	
	public void setProfissionalService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}


	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> getAllCliente(){
		return clienteService.listarTodos();
	}
	
	@GET
	@Path("/id/{pk}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente getUserById(@PathParam("pk") Integer pk){
		return clienteService.buscaPorPk(pk);
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void incluir(Cliente cliente){
		//TODO impmentar a inclusao de usuario
	}
	
}
