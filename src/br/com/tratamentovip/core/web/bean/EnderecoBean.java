package br.com.tratamentovip.core.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.tratamentovip.core.business.services.EnderecoService;
import br.com.tratamentovip.core.persistence.model.Endereco;
import br.com.tratamentovip.core.web.util.FacesUtils;

@ManagedBean
public class EnderecoBean extends AbstractBean{
	private static final String ESTADO_DE_CADASTRO = "_cadastro";
	private static final String ESTADO_DE_EDICAO = "_edicao";
	private static final String ESTADO_DE_PESQUISA = "_pesquisa";
	private Endereco endereco;
	private List<Endereco> enderecos;
	
	@ManagedProperty("#{enderecoService}")
	private EnderecoService enderecoService;
	@ManagedProperty("#{facesUtils}")
	private FacesUtils facesUtils;
	
	

	
	public EnderecoBean(){
		super.setState("_pesquisa");
		endereco = new Endereco();
		enderecos = new ArrayList<Endereco>();
	}

	
	public void voltar() {
		setEndereco(new Endereco());
		facesUtils.cleanSubmittedValues(super.getForm()); // limpa arvore
		setState(ESTADO_DE_PESQUISA);
		listarTodos();
	}
	
	public void preparaParaAdicionar() {
		setEndereco(new Endereco());
		facesUtils.cleanSubmittedValues(super.getForm());
		setState(ESTADO_DE_CADASTRO);
	}
	
	public void preparaParaAlterar(Endereco endereco){
		setEndereco(enderecoService.buscaPorPk(endereco.getId()));
		facesUtils.cleanSubmittedValues(getForm());
		setState(ESTADO_DE_EDICAO);
	}
	
	public void inserir() {
		enderecoService.inserir(getEndereco());
		facesUtils.adicionaMensagemDeInformacao("Endereco adicionado com sucesso!");
		listarTodos();
	}
	
	public void alterar(){
		enderecoService.alterar(endereco);
		facesUtils.adicionaMensagemDeInformacao("Endereco atualizada com sucesso!");
		listarTodos();
	}
	
	@Override
	public void listarTodos() {
		enderecos  = enderecoService.listarTodos();
		setState(ESTADO_DE_PESQUISA);
		
	}

	@Override
	public void consultaPk() {}

	@Override
	public void excluir() {
		enderecoService.excluir(endereco) ;
		facesUtils.adicionaMensagemDeInformacao("Endereço removido com sucesso!");
		listarTodos();
	}

	public EnderecoService getEnderecoService() {
		return enderecoService;
	}

	public void setEnderecoService(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	public FacesUtils getFacesUtils() {
		return facesUtils;
	}

	public void setFacesUtils(FacesUtils facesUtils) {
		this.facesUtils = facesUtils;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
	
	
	
}
