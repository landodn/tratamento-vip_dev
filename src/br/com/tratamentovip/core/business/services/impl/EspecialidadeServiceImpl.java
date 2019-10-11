package br.com.tratamentovip.core.business.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tratamentovip.core.business.services.EspecialidadeService;
import br.com.tratamentovip.core.persistence.model.Especialidade;
import br.com.tratamentovip.core.persistence.repository.EspecialidadeDAO;

@Service("especialidadeService")
public class EspecialidadeServiceImpl implements EspecialidadeService{
	
	private EspecialidadeDAO especialidadeDAO;
	
	@Autowired
	public EspecialidadeServiceImpl(EspecialidadeDAO especialidadeDAO){
		this.especialidadeDAO = especialidadeDAO;
	}
	
	public List<Especialidade> listarTodos(){
		return especialidadeDAO.listarTodos();
	}
	
	public void inserir(Especialidade especialidade){
		especialidadeDAO.inserir(especialidade);
	}
	
	public Especialidade buscaPorPk(Integer pk){
		return especialidadeDAO.buscaPorPk(pk);
	}
	
	public void excluir(Especialidade especialidade){
		especialidadeDAO.excluir(especialidade.getId());
	}
	
	public void alterar(Especialidade especialidade){
		especialidadeDAO.alterar(especialidade);
	}
	
	public List<Especialidade> consultarEspecialidadeSalao(Integer idSalao){
		
		return especialidadeDAO.consultarEspecialidadeSalao(idSalao);
	}
	
}
