package br.com.tratamentovip.core.web.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIForm;

import br.com.tratamentovip.core.business.services.UsuarioService;
import br.com.tratamentovip.core.persistence.model.Usuario;
import br.com.tratamentovip.core.web.util.FacesUtils;

@ManagedBean
public class UsuarioBean extends AbstractBean {

	private String confirmacaoDeSenha;
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	
	private UIForm form;
	
	private String state = ESTADO_DE_PESQUISA;

	@ManagedProperty("#{usuarioService}")
	private UsuarioService usuarioService;
	@ManagedProperty("#{facesUtils}")
	private FacesUtils facesUtils;
	
	public UsuarioBean(){
		usuario = new Usuario();
		usuarios = new ArrayList<Usuario>();
	}
	
	public void listarTodos(){
		usuarios = usuarioService.getAllUsers();
		setState(ESTADO_DE_PESQUISA);
	}
	
	public void preparaParaAdicionar() {
		this.usuario = new Usuario();
		facesUtils.cleanSubmittedValues(form);
		setState(ESTADO_DE_CADASTRO);
	}
	
	public void preparaParaAlterar(Usuario usuario) {
		this.usuario = usuarioService.getUsuarioPk(usuario.getId()); // evita LazyInitializationException
		facesUtils.cleanSubmittedValues(form); // limpa arvore
		setState(ESTADO_DE_EDICAO);
	}

	
	public void inserir() {
		
		boolean senhaInvalida = true;//!confirmacaoDeSenha.equals(usuario.getSenha());
		if (senhaInvalida) {
			facesUtils.adicionaMensagemDeErro("Senha e confirmação de senha não conferem.");
			return;
		}
		usuario.setDataCadastro(new Date());
		usuarioService.cadastra(usuario);
		facesUtils.adicionaMensagemDeInformacao("Usuário adicionado com sucesso!");
		listarTodos();
	}

	public void alterar(){
		boolean senhaInvalida = true;//!confirmacaoDeSenha.equals(usuario.getSenha());
		if (senhaInvalida) {
			facesUtils.adicionaMensagemDeErro("Senha e confirmação de senha não conferem.");
			return;
		}
		usuarioService.atualiza(usuario);
		facesUtils.adicionaMensagemDeInformacao("Usuário atualizado com sucesso!");
		listarTodos();
	}
	
	public void excluir(){
		usuarioService.exclui(usuario);
		facesUtils.adicionaMensagemDeInformacao("Usuário removido com sucesso!");
		listarTodos();
	}
	
	public void voltar() {
		this.usuario = new Usuario();
		facesUtils.cleanSubmittedValues(form); // limpa arvore
		listarTodos();
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

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
	 * @param usuarioService the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
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

	@Override
	public void consultaPk() {
	}
	
}
