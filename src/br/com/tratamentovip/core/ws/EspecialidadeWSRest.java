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

import br.com.tratamentovip.core.business.services.EspecialidadeService;
import br.com.tratamentovip.core.persistence.model.Especialidade;


@Path("/especialidade")
@Component
public class EspecialidadeWSRest {
	
	@Autowired
	private EspecialidadeService especialidadeService;
	
	
	public void setProfissionalService(EspecialidadeService especialidadeService) {
		this.especialidadeService = especialidadeService;
	}


	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Especialidade> getAllEspecialidade(){
		return especialidadeService.listarTodos();
	}
	
	@GET
	@Path("/id/{pk}")
	@Produces(MediaType.APPLICATION_JSON)
	public Especialidade getUserById(@PathParam("pk") Integer pk){
		return especialidadeService.buscaPorPk(pk);
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void incluir(Especialidade especialidade){
		//TODO impmentar a inclusao de usuario
	}
	

	@GET
	@Path("/salao/{salao}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Especialidade> getEspecialidadeSalao(@PathParam("salao") Integer pk){
		return especialidadeService.consultarEspecialidadeSalao(pk);
	}
	
}
