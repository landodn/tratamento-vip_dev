package br.com.tratamentovip.core.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tratamentovip.core.business.services.TipoTelefoneService;
import br.com.tratamentovip.core.persistence.model.TipoTelefone;
import br.com.tratamentovip.core.persistence.repository.TipoTelefoneDAO;

@Service("tipoTelefoneService")
public class TipoTelefoneServiceImpl implements TipoTelefoneService {
	
	private TipoTelefoneDAO tipoTelefoneDAO;
	
	@Autowired
	public TipoTelefoneServiceImpl(TipoTelefoneDAO tipoTelefoneDAO){
		this.tipoTelefoneDAO = tipoTelefoneDAO;
	}
	
	public void inserir(TipoTelefone tipoTelefone){
		tipoTelefoneDAO.inserir(tipoTelefone);
	}
	
	public void alterar(TipoTelefone tipoTelefone){
		tipoTelefoneDAO.alterar(tipoTelefone);
	}
	
	public void excluir(TipoTelefone tipoTelefone){
		tipoTelefoneDAO.excluir(tipoTelefone.getId());
	}
	
	public List<TipoTelefone> listarTodos(){
		return tipoTelefoneDAO.findAll();
	}
	
	public TipoTelefone buscaPorPk(Integer pk){
		return tipoTelefoneDAO.buscaPorPk(pk);
	}
}
