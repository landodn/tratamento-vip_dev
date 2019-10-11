package br.com.tratamentovip.core.persistence.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tratamentovip.core.persistence.model.UF;
import br.com.tratamentovip.core.persistence.repository.UFDAO;

@Repository("ufDAO")
@Transactional
public class UFDAOImpl extends AbstractDAOImpl<UF, Integer> implements UFDAO{
	
	public List<UF> listAll(){
		return super.findAll();
	}
	
	public UF buscaPorPK(Integer pk){
		return super.findById(pk, false);
	}
	
}
