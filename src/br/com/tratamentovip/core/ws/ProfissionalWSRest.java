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

import br.com.tratamentovip.core.business.services.ProfissionalService;
import br.com.tratamentovip.core.persistence.model.Profissional;


@Path("/profissional")
@Component
public class ProfissionalWSRest {
	
	@Autowired
	private ProfissionalService profissionalService;
	
	
	public void setProfissionalService(ProfissionalService profissionalService) {
		this.profissionalService = profissionalService;
	}


	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profissional> getAllProfissional(){
		return profissionalService.getAllProfissional();
	}
	
	@GET
	@Path("/id/{pk}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profissional getUserById(@PathParam("pk") Integer pk){
		return profissionalService.getProfissionalPk(pk);
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void incluir(Profissional profissional){
		//TODO impmentar a inclusao de usuario
	}
	
	@GET
	@Path("/salao/{salao}/especialidade/{especialidade}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profissional> getProfissionalPorSalaoEspecialidade(@PathParam("salao") Integer idSalao, @PathParam("especialidade") Integer idEspecialidade){
		List<Profissional> retorno = null;

		retorno = profissionalService.getProfissionalPorSalaoEspecialidade(idSalao,idEspecialidade);

		for(Profissional profissional : retorno){
			profissional.setProfissionalSalaoBeleza(null);
			profissional.setProfissionalEspecialidade(null);
			//profissional.setTipoUsuario(null);
		}

		return retorno;
	}
	
}
