package br.com.tratamentovip.core.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tratamentovip.core.business.services.UFService;
import br.com.tratamentovip.core.persistence.model.UF;
import br.com.tratamentovip.core.persistence.repository.UFDAO;

@Service("ufService")
public class UFServiceImpl implements UFService {
	
	private UFDAO ufDAO;
	
	@Autowired
	public UFServiceImpl(UFDAO ufDAO){
		this.ufDAO = ufDAO;
	}
	
	public List<UF> listAll(){
		return ufDAO.listAll();
	}
	
	public UF buscaPorPK(Integer pk){
		return ufDAO.buscaPorPK(pk);
	}
}
