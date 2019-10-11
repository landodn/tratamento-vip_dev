package br.com.tratamentovip.core.business.services;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.UF;

public interface UFService {
	
	public List<UF> listAll();
	
	public UF buscaPorPK(Integer pk);
}
