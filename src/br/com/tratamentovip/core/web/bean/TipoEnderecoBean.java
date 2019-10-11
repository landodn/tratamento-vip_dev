package br.com.tratamentovip.core.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.tratamentovip.core.business.services.TipoEnderecoService;
import br.com.tratamentovip.core.persistence.model.TipoEndereco;
import br.com.tratamentovip.core.web.util.FacesUtils;

@ManagedBean
public class TipoEnderecoBean extends AbstractBean{
	
	private TipoEndereco tipoEndereco;
	private List<TipoEndereco> tiposEndereco;
	
	@ManagedProperty("#{facesUtils}")
	private FacesUtils facesUtils;
	
	@ManagedProperty("#{tipoEnderecoService}")
	private TipoEnderecoService service;
	
	public TipoEnderecoBean(){
		super.setState(ESTADO_DE_PESQUISA);
		tipoEndereco = new TipoEndereco();
		tiposEndereco = new ArrayList<TipoEndereco>();
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

	public void preparaParaInserir() {
		tipoEndereco = new TipoEndereco();
		facesUtils.cleanSubmittedValues(super.getForm());
		super.setState(ESTADO_DE_CADASTRO);
	}
	
	public void preparaParaAlterar(TipoEndereco tipoEndereco){
		this.tipoEndereco= service.buscaPorPk(tipoEndereco.getId());
		facesUtils.cleanSubmittedValues(super.getForm());
		super.setState(ESTADO_DE_EDICAO);
	}
	
	@Override
	public void listarTodos() {
		tiposEndereco = service.listarTodos();
		super.setState(ESTADO_DE_PESQUISA);
	}

	@Override
	public void consultaPk() {
	}

	@Override
	public void inserir() {
		service.inserir(getTipoEndereco());
		facesUtils.adicionaMensagemDeInformacao("Tipo de Endereco inserido com sucesso.");
		listarTodos();
	}

	@Override
	public void alterar() {
		service.alterar(getTipoEndereco());
		facesUtils.adicionaMensagemDeInformacao("Tipo de Endereco alterado com sucesso");
		listarTodos();
	}

	@Override
	public void excluir() {
		service.excluir(getTipoEndereco());
		facesUtils.adicionaMensagemDeInformacao("Tipo de Endereco excluido com sucesso");
		listarTodos();
	}

	@Override
	public void voltar() {
		tipoEndereco = new TipoEndereco();
		facesUtils.cleanSubmittedValues(super.getForm());
		super.setState(ESTADO_DE_PESQUISA);
		listarTodos();
	}
	
	/**
	 * @return the tipoEndereco
	 */
	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	/**
	 * @param tipoEndereco the tipoEndereco to set
	 */
	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	/**
	 * @return the tiposEndereco
	 */
	public List<TipoEndereco> getTiposEndereco() {
		return tiposEndereco;
	}

	/**
	 * @param tiposEndereco the tiposEndereco to set
	 */
	public void setTiposEndereco(List<TipoEndereco> tiposEndereco) {
		this.tiposEndereco = tiposEndereco;
	}

	/**
	 * @param facesUtils the facesUtils to set
	 */
	public void setFacesUtils(FacesUtils facesUtils) {
		this.facesUtils = facesUtils;
	}

	/**
	 * @param tipoEnderecoService the tipoEnderecoService to set
	 */
	public void setService(TipoEnderecoService service) {
		this.service = service;
	}
	
}
