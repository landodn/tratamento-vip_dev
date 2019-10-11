package br.com.tratamentovip.core.web.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import br.com.tratamentovip.core.business.services.SalaoBelezaService;
import br.com.tratamentovip.core.business.services.TipoTelefoneService;
import br.com.tratamentovip.core.business.services.UFService;
import br.com.tratamentovip.core.persistence.model.Endereco;
import br.com.tratamentovip.core.persistence.model.SalaoBeleza;
import br.com.tratamentovip.core.persistence.model.Telefone;
import br.com.tratamentovip.core.persistence.model.TipoEndereco;
import br.com.tratamentovip.core.persistence.model.TipoTelefone;
import br.com.tratamentovip.core.persistence.model.TipoUsuario;
import br.com.tratamentovip.core.persistence.model.UF;
import br.com.tratamentovip.core.web.util.FacesUtils;

@ManagedBean(name="salaoBelezaBean")
public class SalaoBelezaBean extends AbstractBean {

	private SalaoBeleza salaoBeleza;
	private List<SalaoBeleza> lstSalaoBeleza;
	private List<UF> lstUF;

	@ManagedProperty("#{salaoBelezaService}")
	private SalaoBelezaService salaoBelezaService;

	@ManagedProperty("#{facesUtils}")
	private FacesUtils facesUtils;

	@ManagedProperty("#{ufService}")
	private UFService ufService;
	@ManagedProperty("#{tipoTelefoneService}")
	private TipoTelefoneService tipoTelefoneService;


	public SalaoBelezaBean() {
		if(this.getSalaoBeleza() == null) {
			this.setSalaoBeleza(new SalaoBeleza());
			this.getSalaoBeleza().setEndereco(new Endereco());
			this.getSalaoBeleza().getEndereco().setUf(new UF());
			this.getSalaoBeleza().getEndereco().setTipoEndereco(new TipoEndereco());
			List<Telefone> lstTelefones = new ArrayList<Telefone>();
			Telefone telefone = new Telefone();
			telefone.setTipoTelefone(new TipoTelefone());
			lstTelefones.add(telefone);
			this.getSalaoBeleza().setTelefonesSalaoBeleza(lstTelefones);
		}
	}

	@Override
	public void listarTodos() {
		lstSalaoBeleza = salaoBelezaService.listarTodos();
	}

	@Override
	public void consultaPk() {
	}

	public void addTelefone() {
		super.setState(ESTADO_DE_CADASTRO);
		Telefone telefone = new Telefone();
		telefone.setTipoTelefone(new TipoTelefone());
		getSalaoBeleza().getTelefonesSalaoBeleza().add(telefone);
	}

	public void delTelefone() {
	       List<Telefone> lstTelefones = getSalaoBeleza().getTelefonesSalaoBeleza();
		 
		  // UIParameter parameter = (UIParameter) event.getComponent().findComponent("idx");  
	        //long idEntidade = Long.parseLong( parameter.getValue().toString() ); 
		
		   lstTelefones.remove(1);
		super.setState(ESTADO_DE_CADASTRO);

	}

	public UF consultaPk(Integer pk) {
		return ufService.buscaPorPK(pk);
	}

	public void preparaParaAdicionar(){
		setSalaoBeleza(new SalaoBeleza());
		getSalaoBeleza().setEndereco(new Endereco());
		getSalaoBeleza().getEndereco().setUf(new UF());
		getSalaoBeleza().getEndereco().setTipoEndereco(new TipoEndereco());
		setLstUF(ufService.listAll());
		facesUtils.cleanSubmittedValues(super.getForm());
		setState(ESTADO_DE_CADASTRO);
	}

	public String preCadastro(){
		super.setState(ESTADO_DE_CADASTRO);
		return "cadastro";
	}

	public List<UF> getUfs(){
		return ufService.listAll();
	}

	public List<TipoTelefone> getTiposTelefones(){
		return tipoTelefoneService.listarTodos();
	}

	@Override
	public void inserir() {
		if(salaoBeleza != null) {
			salaoBeleza.setDataCadastro(new Date());
			salaoBeleza.setTipoUsuario(new TipoUsuario(3));
			salaoBelezaService.inserir(salaoBeleza);
			// facesUtils.adicionaMensagemDeInformacao("Salão de Beleza adicionado com sucesso!");
			// listarTodos(); 
		}
	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void voltar() {
		// TODO Auto-generated method stub

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

	public void setFacesUtils(FacesUtils facesUtils) {
		this.facesUtils = facesUtils;
	}

	/**
	 * @param salaoBelezaService the salaoBelezaService to set
	 */
	public void setSalaoBelezaService(SalaoBelezaService salaoBelezaService) {
		this.salaoBelezaService = salaoBelezaService;
	}

	/**
	 * @param ufService the ufService to set
	 */
	public void setUfService(UFService ufService) {
		this.ufService = ufService;
	}

	/**
	 * @param tipoTelefoneService the tipoTelefoneService to set
	 */
	public void setTipoTelefoneService(TipoTelefoneService tipoTelefoneService) {
		this.tipoTelefoneService = tipoTelefoneService;
	}

	/**
	 * @return the salaoBeleza
	 */
	public SalaoBeleza getSalaoBeleza() {
		return salaoBeleza;
	}

	/**
	 * @param salaoBeleza the salaoBeleza to set
	 */
	public void setSalaoBeleza(SalaoBeleza salaoBeleza) {
		this.salaoBeleza = salaoBeleza;
	}

	/**
	 * @return the lstSalaoBeleza
	 */
	public List<SalaoBeleza> getLstSalaoBeleza() {
		return lstSalaoBeleza;
	}

	/**
	 * @param lstSalaoBeleza the lstSalaoBeleza to set
	 */
	public void setLstSalaoBeleza(List<SalaoBeleza> lstSalaoBeleza) {
		this.lstSalaoBeleza = lstSalaoBeleza;
	}

	/**
	 * @return the lstUF
	 */
	public List<UF> getLstUF() {
		return lstUF;
	}

	/**
	 * @param lstUF the lstUF to set
	 */
	public void setLstUF(List<UF> lstUF) {
		this.lstUF = lstUF;
	}

}