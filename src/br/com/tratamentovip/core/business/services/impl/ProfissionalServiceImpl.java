package br.com.tratamentovip.core.business.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tratamentovip.core.business.services.ProfissionalService;
import br.com.tratamentovip.core.persistence.model.Profissional;
import br.com.tratamentovip.core.persistence.repository.ProfissionalDAO;

@Service("profissionalService")
public class ProfissionalServiceImpl implements ProfissionalService{
	
	private ProfissionalDAO profissionalDao;
	
	@Autowired
	public ProfissionalServiceImpl(ProfissionalDAO profissionalDAO){
		this.profissionalDao = profissionalDAO;
	}
	
	/**
	 * Retorna todos os usuarios sem restricao
	 */
	public List<Profissional> getAllProfissional(){
		List<Profissional> lstProfissional = profissionalDao.findAll();
		//if(lstProfissional != null && lstProfissional.size() > 0){
		//	for(Profissional profissional : lstProfissional){
				//profissional.setNome("");
		//	}
		//}
		return lstProfissional;
	}
	
	/**
	 * Retorna um usuario especifico, de acordo com o ID informado
	 */
	public Profissional getProfissionalPk(Integer pk){
		Profissional profissional = profissionalDao.findById(pk, false);
			
		return profissional;
	}
	
	public void cadastra(Profissional profissional){
		profissional.setDataCadastro(new Date());
		profissionalDao.cadastra(profissional);
	}
	
	public void atualiza(Profissional profissional){
		profissionalDao.altera(profissional);
	}
	
	public void exclui(Profissional profissional){
		profissionalDao.exclui(profissional.getId());
	}
	
	public List<Profissional> getProfissionalPorSalaoEspecialidade(
			Integer idSalaoBeleza, Integer idEspecialidade) { 
		return profissionalDao.getProfissionalPorSalaoEspecialidade(idSalaoBeleza, idEspecialidade);
	}

}
