package br.com.tratamentovip.core.persistence.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tratamentovip.core.persistence.model.TipoTelefone;
import br.com.tratamentovip.core.persistence.repository.TipoTelefoneDAO;

@Repository("tipoTelefoneDAO")
@Transactional
public class TipoTelefoneDAOImpl extends AbstractDAOImpl<TipoTelefone, Integer> implements TipoTelefoneDAO{
	
	public void inserir(TipoTelefone tipoTelefone){
		super.persist(tipoTelefone);
	}
	
	public void alterar(TipoTelefone tipoTelefone){
		super.update(tipoTelefone);
	}
	
	public void excluir(Integer pk){
		super.delete(pk);
	}
	
	public List<TipoTelefone> listarTodos(){
		return super.findAll();
	}
	
	public TipoTelefone buscaPorPk(Integer pk){
		return super.findById(pk, false);
	}
}
