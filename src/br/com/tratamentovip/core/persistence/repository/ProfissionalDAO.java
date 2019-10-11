package br.com.tratamentovip.core.persistence.repository;

import java.util.List;

import br.com.tratamentovip.core.persistence.model.Profissional;

public interface ProfissionalDAO extends DAO<Profissional, Integer> {
	
	
	public void cadastra(Profissional profissional);
	
	public Profissional consulta(Integer pk);
	
	public void altera(Profissional profissional);
	
	public void exclui(Integer pk);
	
	public List<Profissional> getProfissionalPorSalaoEspecialidade(Integer salaoBeleza, Integer especialidade);
}
