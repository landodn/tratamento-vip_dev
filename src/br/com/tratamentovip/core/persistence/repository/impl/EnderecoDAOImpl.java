package br.com.tratamentovip.core.persistence.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tratamentovip.core.persistence.model.Endereco;
import br.com.tratamentovip.core.persistence.repository.EnderecoDAO;

@Repository("enderecoDAO")
@Transactional
public class EnderecoDAOImpl extends AbstractDAOImpl<Endereco, Integer> implements EnderecoDAO{

	
	public void inserir(Endereco endereco) {
		super.persist(endereco);
	}
	
	public List<Endereco> listarTodos(){
		return super.findAll();
	}

	public Endereco buscaPorPk(Integer pk){
		return findById(pk, false);
	}
	
	public void alterar(Endereco endereco){
		super.update(endereco);
	}
	
	public void Endereco(Integer pk){
		super.delete(pk);
	}

	@Override
	public void excluir(Integer pk){
		super.delete(pk);
	}
	
}
