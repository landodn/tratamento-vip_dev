package br.com.tratamentovip.core.business.services;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.Profissional;


public interface ProfissionalService {
	
	public List<Profissional> getAllProfissional();
	
	public Profissional getProfissionalPk(Integer pk);
	
	public void cadastra(Profissional profissional);
	
	public void atualiza(Profissional profissional);
	
	public void exclui(Profissional profissional);
	
	public List<Profissional> getProfissionalPorSalaoEspecialidade(
			Integer idSalaoBeleza, Integer idEspecialidade);
}
