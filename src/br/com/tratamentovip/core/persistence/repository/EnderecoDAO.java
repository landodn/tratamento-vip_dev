package br.com.tratamentovip.core.persistence.repository;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.Endereco;

public interface EnderecoDAO extends  DAO<Endereco, Integer>{
	
	public void inserir(Endereco endereco);
		
	
	public List<Endereco> listarTodos();

	public Endereco buscaPorPk(Integer pk);
	
	public void alterar(Endereco endereco);
	
	public void Endereco(Integer pk);
	
	public void excluir(Integer pk);

}
