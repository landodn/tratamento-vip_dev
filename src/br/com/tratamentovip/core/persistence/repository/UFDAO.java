package br.com.tratamentovip.core.persistence.repository;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.UF;

public interface UFDAO extends DAO<UF, Integer>{
	
	public List<UF> listAll();
	
	public UF buscaPorPK(Integer pk);
}
