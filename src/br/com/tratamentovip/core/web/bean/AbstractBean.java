package br.com.tratamentovip.core.web.bean;

import javax.faces.component.UIForm;


public abstract class AbstractBean {
	
	protected static final String ESTADO_DE_CADASTRO = "_cadastro";
	protected static final String ESTADO_DE_EDICAO = "_edicao";
	protected static final String ESTADO_DE_PESQUISA = "_pesquisa";
	
	private String state;
	
	private UIForm form;
	
	public abstract void listarTodos();
	
	public abstract void consultaPk();
	
	public abstract void inserir();
	
	public abstract void alterar();
	
	public abstract void excluir();
	
	public abstract void voltar();
	
	public UIForm getForm() {
		return form;
	}
	
	public void setForm(UIForm form) {
		this.form = form;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state){
		this.state = state;
	}
}
