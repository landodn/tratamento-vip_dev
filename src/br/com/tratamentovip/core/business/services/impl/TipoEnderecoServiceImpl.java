package br.com.tratamentovip.core.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tratamentovip.core.business.services.TipoEnderecoService;
import br.com.tratamentovip.core.persistence.model.TipoEndereco;
import br.com.tratamentovip.core.persistence.repository.TipoEnderecoDAO;

@Service("tipoEnderecoService")
public class TipoEnderecoServiceImpl implements TipoEnderecoService{
	
	private TipoEnderecoDAO tipoEnderecoDAO;
	
	@Autowired
	public TipoEnderecoServiceImpl(TipoEnderecoDAO tipoEnderecoDAO){
		this.tipoEnderecoDAO = tipoEnderecoDAO;
	}
	
	@Override
	public void inserir(TipoEndereco tipoEndereco) {
		tipoEnderecoDAO.inserir(tipoEndereco);
	}

	@Override
	public void alterar(TipoEndereco tipoEndereco) {
		tipoEnderecoDAO.alterar(tipoEndereco);
	}

	@Override
	public void excluir(TipoEndereco tipoEndereco) {
		tipoEnderecoDAO.excluir(tipoEndereco.getId());
	}

	@Override
	public List<TipoEndereco> listarTodos() {
		return tipoEnderecoDAO.listarTodos();
	}

	@Override
	public TipoEndereco buscaPorPk(Integer pk) {
		return tipoEnderecoDAO.buscaPorPk(pk);
	}

	/**
	 * @param tipoEnderecoDAO the tipoEnderecoDAO to set
	 */
	public void setTipoEnderecoDAO(TipoEnderecoDAO tipoEnderecoDAO) {
		this.tipoEnderecoDAO = tipoEnderecoDAO;
	}
}
