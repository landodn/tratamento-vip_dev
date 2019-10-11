package br.com.tratamentovip.core.persistence.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tratamentovip.core.persistence.model.TipoEndereco;
import br.com.tratamentovip.core.persistence.repository.TipoEnderecoDAO;

@Repository("tipoEnderecoDAO")
@Transactional
public class TipoEnderecoDAOImpl extends AbstractDAOImpl<TipoEndereco, Integer> implements TipoEnderecoDAO{

	@Override
	public void inserir(TipoEndereco tipoEndereco) {
		super.persist(tipoEndereco);
	}

	@Override
	public void alterar(TipoEndereco tipoEndereco) {
		super.update(tipoEndereco);
	}

	@Override
	public void excluir(Integer pk) {
		super.delete(pk);
	}

	@Override
	public List<TipoEndereco> listarTodos() {
		return super.findAll();
	}

	@Override
	public TipoEndereco buscaPorPk(Integer pk) {
		return super.findById(pk, false);
	}

}
