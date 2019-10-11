package br.com.tratamentovip.core.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.tratamentovip.core.business.services.EspecialidadeService;
import br.com.tratamentovip.core.persistence.model.Especialidade;
import br.com.tratamentovip.core.web.util.FacesUtils;

@ManagedBean
public class EspecialidadeBean extends AbstractBean{
	
	private Especialidade especialidade;
	private List<Especialidade> especialidades;
	
	@ManagedProperty("#{facesUtils}")
	private FacesUtils facesUtils;

	@ManagedProperty("#{especialidadeService}")
	private EspecialidadeService especialidadeService;
	
	public EspecialidadeBean(){
		super.setState(ESTADO_DE_PESQUISA);
		especialidade = new Especialidade();
		especialidades = new ArrayList<Especialidade>();
	}
	
	public void voltar() {
		setEspecialidade(new Especialidade());
		facesUtils.cleanSubmittedValues(super.getForm()); // limpa arvore
		setState(ESTADO_DE_PESQUISA);
		listarTodos();
	}
	
	public void preparaParaAdicionar() {
		setEspecialidade(new Especialidade());
		facesUtils.cleanSubmittedValues(super.getForm());
		setState(ESTADO_DE_CADASTRO);
	}
	
	public void preparaParaAlterar(Especialidade especialidade){
		this.setEspecialidade(especialidadeService.buscaPorPk(especialidade.getId()));
		facesUtils.cleanSubmittedValues(getForm());
		setState(ESTADO_DE_EDICAO);
	}
	
	public void inserir() {
		especialidadeService.inserir(getEspecialidade());
		facesUtils.adicionaMensagemDeInformacao("Especialidade adicionada com sucesso!");
		listarTodos();
	}
	
	public void alterar(){
		especialidadeService.alterar(especialidade);
		facesUtils.adicionaMensagemDeInformacao("Especialidade atualizada com sucesso!");
		listarTodos();
	}

	public void listarTodos(){
		especialidades = especialidadeService.listarTodos();
		setState(ESTADO_DE_PESQUISA);
	}
	
	public void consultaPk(){}
	
	public void excluir(){
		especialidadeService.excluir(especialidade);
		facesUtils.adicionaMensagemDeInformacao("Usuário removido com sucesso!");
		listarTodos();
	}
	
	/**
	 * @param especialidadeService the especialidadeService to set
	 */
	public void setEspecialidadeService(EspecialidadeService especialidadeService) {
		this.especialidadeService = especialidadeService;
	}

	/**
	 * @return the especialidade
	 */
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	/**
	 * @param especialidade the especialidade to set
	 */
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	/**
	 * @return the especialidades
	 */
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}
	/**
	 * @param especialidades the especialidades to set
	 */
	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}
	
	public boolean isAdicionando() {
		return ESTADO_DE_CADASTRO.equals(super.getState());
	}
	public boolean isEditando() {
		return ESTADO_DE_EDICAO.equals(super.getState());
	}
	public boolean isPesquisando() {
		return ESTADO_DE_PESQUISA.equals(super.getState());
	}
	
	/**
	 * @param facesUtils the facesUtils to set
	 */
	public void setFacesUtils(FacesUtils facesUtils) {
		this.facesUtils = facesUtils;
	}

}
