package br.com.tratamentovip.core.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import br.com.tratamentovip.core.business.services.SalaoBelezaService;
import br.com.tratamentovip.core.persistence.model.Endereco;
import br.com.tratamentovip.core.persistence.model.Especialidade;
import br.com.tratamentovip.core.persistence.model.SalaoBeleza;
import br.com.tratamentovip.core.persistence.model.TipoEndereco;
import br.com.tratamentovip.core.persistence.model.TipoUsuario;

@Path("/salao")
@Component
public class SalaoBelezaWSRest {
	
	@Autowired
	private SalaoBelezaService salaoService;

	/**
	 * @param salaoService the salaoService to set
	 */
	public void setSalaoService(SalaoBelezaService salaoService) {
		this.salaoService = salaoService;
	}
	
	@PUT
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarSalao(SalaoBeleza salaoBeleza){
		if(salaoBeleza != null){
			try{
				salaoBeleza.setDataCadastro(new Date());
				
				TipoUsuario tipoUsuario = new TipoUsuario();
				tipoUsuario.setId(3);

				salaoBeleza.setTipoUsuario(tipoUsuario);
				
				Endereco endereco = salaoBeleza.getEndereco();
				if(endereco != null){
					TipoEndereco tipoEndereco = new TipoEndereco();
					tipoEndereco.setId(1);
					endereco.setTipoEndereco(tipoEndereco);
				}
				if(salaoBeleza.getEspecialidadeSalao() == null || salaoBeleza.getEspecialidadeSalao().size() == 0){
					List<Especialidade> lstEspecialidade = new ArrayList<Especialidade>();
					Especialidade especialidade1 = new Especialidade();
					especialidade1.setId(1);
					lstEspecialidade.add(especialidade1);
					
					salaoBeleza.setEspecialidadeSalao(lstEspecialidade);
				}
			}catch(Exception ex){
				return Response.status(505).entity(salaoBeleza).build();
			}
			salaoService.cadastrar(salaoBeleza);
		}
		return Response.status(201).entity(salaoBeleza).build();
	}
	
	@GET
	@Path("/raio")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SalaoBeleza> getSalaoBelezaRaio(@PathParam("latitude") String latitude, @PathParam("longitude") String longitude){
		
		return null;
	}
	
	@GET
	@Path("/regiao/{regiao}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SalaoBeleza> consultarSalao(@PathParam("regiao") String regiao){
		
		List<SalaoBeleza> retorno = salaoService.consultarSalao(regiao);
			
		return retorno;
	}
	
	@GET
	@Path("/regiao/{regiao}/bairro/{bairro}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SalaoBeleza> consultarSalao(@PathParam("regiao") String regiao, @PathParam("bairro") String bairro){
		
		List<SalaoBeleza> retorno = salaoService.consultarSalao(regiao, bairro);
		
		return retorno;
	}
	
	@GET
	@Path("/regiao/{regiao}/bairro/{bairro}/especialidade/{especialidade}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SalaoBeleza> getSalaoPorRegiaoBairroEspecialidade(@PathParam("regiao") String regiao, @PathParam("bairro") String bairro, @PathParam("especialidade") Integer idEspecialidade){
		
		return null;
	}
	
	@GET
	@Path("/id/{pk}")
	@Produces(MediaType.APPLICATION_JSON)
	public SalaoBeleza consultarSalao(@PathParam("pk") Integer pk){
		
		SalaoBeleza 	retorno = salaoService.consultarSalao(pk);
		
		return retorno;
	}
	
}
