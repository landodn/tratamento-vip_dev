package br.com.tratamentovip.core.business.services;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.Endereco;


public interface EnderecoService {
	
	public List<Endereco> listarTodos();
	
	public Endereco buscaPorPk(Integer pk);
	
	public void inserir(Endereco endereco);
	
	public void excluir(Endereco endereco);
	
	public void alterar(Endereco endereco);

}
