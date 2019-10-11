package br.com.tratamentovip.core.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.tratamentovip.core.business.services.TipoTelefoneService;
import br.com.tratamentovip.core.persistence.model.TipoTelefone;
import br.com.tratamentovip.core.web.util.FacesUtils;

@ManagedBean
public class TipoTelefoneBean extends AbstractBean{

	private TipoTelefone tipoTelefone;
	private List<TipoTelefone> tiposTelefone;
	
	@ManagedProperty("#{facesUtils}")
	private FacesUtils facesUtils;

	@ManagedProperty("#{tipoTelefoneService}")
	private TipoTelefoneService tipoTelefoneService;
	
	public TipoTelefoneBean(){
		super.setState(ESTADO_DE_PESQUISA);
		this.tipoTelefone = new TipoTelefone();
		this.tiposTelefone = new ArrayList<TipoTelefone>();
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
		tipoTelefone = new TipoTelefone();
		facesUtils.cleanSubmittedValues(super.getForm());
		setState(ESTADO_DE_CADASTRO);
	}
	
	public void preparaParaAlterar(TipoTelefone tipoTelefone){
		this.tipoTelefone = tipoTelefoneService.buscaPorPk(tipoTelefone.getId());
		facesUtils.cleanSubmittedValues(getForm());
		setState(ESTADO_DE_EDICAO);
	}
	
	@Override
	public void listarTodos() {
		tiposTelefone = tipoTelefoneService.listarTodos();
		setState(ESTADO_DE_PESQUISA);
	}

	@Override
	public void consultaPk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserir() {
		tipoTelefoneService.inserir(getTipoTelefone());
		facesUtils.adicionaMensagemDeInformacao("Tipo de Telefone inserido com sucesso.");
		listarTodos();
	}

	@Override
	public void alterar() {
		tipoTelefoneService.alterar(getTipoTelefone());
		facesUtils.adicionaMensagemDeInformacao("Tipo de Telefone alterado com sucesso.");
		listarTodos();
	}

	@Override
	public void excluir() {
		tipoTelefoneService.excluir(getTipoTelefone());
		facesUtils.adicionaMensagemDeInformacao("Tipo de Telefone excluido com sucesso.");
		listarTodos();
	}

	@Override
	public void voltar() {
		this.tipoTelefone = new TipoTelefone();
		facesUtils.cleanSubmittedValues(getForm());
		setState(ESTADO_DE_PESQUISA);
		listarTodos();
	}
	
	/**
	 * @return the tipoTelefone
	 */
	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	/**
	 * @param tipoTelefone the tipoTelefone to set
	 */
	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	/**
	 * @return the tiposTelefone
	 */
	public List<TipoTelefone> getTiposTelefone() {
		return tiposTelefone;
	}

	/**
	 * @param tiposTelefone the tiposTelefone to set
	 */
	public void setTiposTelefone(List<TipoTelefone> tiposTelefone) {
		this.tiposTelefone = tiposTelefone;
	}

	/**
	 * @param facesUtils the facesUtils to set
	 */
	public void setFacesUtils(FacesUtils facesUtils) {
		this.facesUtils = facesUtils;
	}

	/**
	 * @param tipoTelefoneService the tipoTelefoneService to set
	 */
	public void setTipoTelefoneService(TipoTelefoneService tipoTelefoneService) {
		this.tipoTelefoneService = tipoTelefoneService;
	}
}
