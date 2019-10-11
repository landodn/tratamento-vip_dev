package br.com.tratamentovip.core.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tratamentovip.core.business.services.EnderecoService;
import br.com.tratamentovip.core.persistence.model.Endereco;
import br.com.tratamentovip.core.persistence.repository.EnderecoDAO;


@Service("enderecoService")
public class EnderecoServiceImpl implements EnderecoService{

	private EnderecoDAO enderecoDAO;
	
	@Autowired
	public EnderecoServiceImpl(EnderecoDAO enderecoDAO){
		this.enderecoDAO = enderecoDAO;
	}

	@Override
	public List<Endereco> listarTodos() {
		return enderecoDAO.listarTodos();
	}


	@Override
	public void inserir(Endereco endereco) {
		enderecoDAO.inserir(endereco);
	}

	@Override
	public Endereco buscaPorPk(Integer pk) {
		return enderecoDAO.buscaPorPk(pk);
	}

	@Override
	public void excluir(Endereco endereco) {
		enderecoDAO.excluir(endereco.getId());
	}

	@Override
	public void alterar(Endereco endereco) {
		enderecoDAO.alterar(endereco);
		
	}

}
