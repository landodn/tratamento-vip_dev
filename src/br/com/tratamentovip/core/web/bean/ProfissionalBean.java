package br.com.tratamentovip.core.web.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIForm;
import javax.faces.model.SelectItem;

import br.com.tratamentovip.core.business.services.EspecialidadeService;
import br.com.tratamentovip.core.business.services.ProfissionalService;
import br.com.tratamentovip.core.business.services.SalaoBelezaService;
import br.com.tratamentovip.core.persistence.model.Especialidade;
import br.com.tratamentovip.core.persistence.model.Profissional;
import br.com.tratamentovip.core.web.util.FacesUtils;

@ManagedBean(name="profissionalBean")
@RequestScoped
public class ProfissionalBean {
	private static final String ESTADO_DE_CADASTRO = "_cadastro";
	private static final String ESTADO_DE_EDICAO = "_edicao";
	private static final String ESTADO_DE_PESQUISA = "_pesquisa";
	private String confirmacaoDeSenha;
	
	private Profissional profissional;
	private List<Profissional> profissionais;
	private List<Especialidade> especialidades;
	
	//atributos
	private Especialidade especialidade;
	private String nomefunc;
	private String tma;
	
    private UIForm form;
	
	private String state = ESTADO_DE_PESQUISA;

	@ManagedProperty("#{profissionalService}")
	private ProfissionalService profissionalService;
	
	@ManagedProperty("#{especialidadeService}")
	private EspecialidadeService especialidadeService;
	
	@ManagedProperty("#{salaoBelezaService}")
	private SalaoBelezaService salaoBelezaService;
	
	@ManagedProperty("#{facesUtils}")
	private FacesUtils facesUtils;
	
	public ProfissionalBean(){
		profissional = new Profissional();
		profissionais = new ArrayList<Profissional>();
	}
	
	public void lista(){
		profissionais = profissionalService.getAllProfissional();
		setState(ESTADO_DE_PESQUISA);
	}
	
	public String preparaParaAdicionar() {
		this.profissional = new Profissional();
		 this.especialidades = especialidadeService.listarTodos();	
		return "profissional";
	}
	
	public Collection getEspecialidadeComboBox(){  
		 this.especialidades = especialidadeService.listarTodos();	
		  Collection toReturn = new ArrayList();  
		  for( Especialidade e :  especialidades ){  
		    toReturn.add( new SelectItem( e.getId(), e.getDescricao() ) );  
		  }
		return toReturn;  
	}  
	
	public void preparaParaAlterar(Profissional profissional) {
		this.profissional = profissionalService.getProfissionalPk(profissional.getId()); // evita LazyInitializationException
		facesUtils.cleanSubmittedValues(form); // limpa arvore
		setState(ESTADO_DE_EDICAO);
	}

	public void pesquisa(){
	   System.out.println("Entrou no pesquisa");
	}
	
	
	
	public void adiciona() {
		 System.out.println("Entrou no Cadastra");
		 this.profissional = new Profissional();
		 
		 profissional.setDataCadastro(new Date());
		//TODO adicionar dados do funcionario no objeto
		
		profissionalService.cadastra(profissional);
		
		
		
		facesUtils.adicionaMensagemDeInformacao("Profissional adicionado com sucesso!");
		lista();
	}

	public void altera(){
		
		profissionalService.atualiza(profissional);
		facesUtils.adicionaMensagemDeInformacao("Profissional atualizado com sucesso!");
		lista();
	}
	
	public void exclui(){
		profissionalService.exclui(profissional);
		facesUtils.adicionaMensagemDeInformacao("Profissional removido com sucesso!");
		lista();
	}
	
	public void voltar() {
		this.profissional = new Profissional();
		facesUtils.cleanSubmittedValues(form); // limpa arvore
		lista();
	}

	public boolean isAdicionando() {
		return ESTADO_DE_CADASTRO.equals(state);
	}
	public boolean isEditando() {
		return ESTADO_DE_EDICAO.equals(state);
	}
	public boolean isPesquisando() {
		return ESTADO_DE_PESQUISA.equals(state);
	}

	
	
	public UIForm getForm() {
		return form;
	}
	
	public void setForm(UIForm form) {
		this.form = form;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

		/**
	 * @param facesUtils the facesUtils to set
	 */
	public void setFacesUtils(FacesUtils facesUtils) {
		this.facesUtils = facesUtils;
	}
	
	public String getConfirmacaoDeSenha() {
		return confirmacaoDeSenha;
	}
	public void setConfirmacaoDeSenha(String confirmacaoDeSenha) {
		this.confirmacaoDeSenha = confirmacaoDeSenha;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public String getNomefunc() {
		return nomefunc;
	}

	public void setNomefunc(String nomefunc) {
		this.nomefunc = nomefunc;
	}

	public String getTma() {
		return tma;
	}

	public void setTma(String tma) {
		this.tma = tma;
	}

	public ProfissionalService getProfissionalService() {
		return profissionalService;
	}

	public void setProfissionalService(ProfissionalService profissionalService) {
		this.profissionalService = profissionalService;
	}

	public EspecialidadeService getEspecialidadeService() {
		return especialidadeService;
	}

	public void setEspecialidadeService(EspecialidadeService especialidadeService) {
		this.especialidadeService = especialidadeService;
	}

	public SalaoBelezaService getSalaoBelezaService() {
		return salaoBelezaService;
	}

	public void setSalaoBelezaService(SalaoBelezaService salaoBelezaService) {
		this.salaoBelezaService = salaoBelezaService;
	}

		
	
}
