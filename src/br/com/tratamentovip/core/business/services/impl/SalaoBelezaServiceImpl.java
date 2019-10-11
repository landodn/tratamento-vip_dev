package br.com.tratamentovip.core.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tratamentovip.core.business.services.SalaoBelezaService;
import br.com.tratamentovip.core.persistence.model.Especialidade;
import br.com.tratamentovip.core.persistence.model.SalaoBeleza;
import br.com.tratamentovip.core.persistence.repository.SalaoBelezaDAO;

@Service("salaoBelezaService")
public class SalaoBelezaServiceImpl implements SalaoBelezaService{
	
	private SalaoBelezaDAO salaoBelezaDAO;
	
	/**
	 * @param salaoBelezaDAO the salaoBelezaDAO to set
	 */
	public void setSalaoBelezaDAO(SalaoBelezaDAO salaoBelezaDAO) {
		this.salaoBelezaDAO = salaoBelezaDAO;
	}
	
	@Autowired
	public SalaoBelezaServiceImpl(SalaoBelezaDAO salaoBelezaDAO){
		this.salaoBelezaDAO = salaoBelezaDAO;
	}
	
	public void cadastrar(SalaoBeleza salaoBeleza){
		salaoBelezaDAO.cadastrar(salaoBeleza);
	}
	
	public SalaoBeleza consulta(String nome){
		return null;
	}
	
	public List<SalaoBeleza> consultarSalao(String regiao){
		return salaoBelezaDAO.consultarSalao(regiao);
	}
	
	public List<SalaoBeleza> consultarSalao(String regiao, String bairro){
		return salaoBelezaDAO.consultarSalao(regiao, bairro);
	}
	
	public SalaoBeleza consultarSalao(Integer pk){
		return salaoBelezaDAO.consultarSalao(pk);
	}
	
	public List<SalaoBeleza> listarTodos(){
		return salaoBelezaDAO.listarTodos();
	}
	
	public void inserir(SalaoBeleza salaoBeleza){
		salaoBelezaDAO.inserir(salaoBeleza);
	}

	@Override
	public List<SalaoBeleza> getSalaoRegiao(String regiao) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
