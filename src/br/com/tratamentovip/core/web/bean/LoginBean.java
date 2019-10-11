package br.com.tratamentovip.core.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.tratamentovip.core.business.services.LoginService;
import br.com.tratamentovip.core.persistence.model.Usuario;
import br.com.tratamentovip.core.web.util.FacesUtils;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean {

	private String loginEmail;
	private String senha;
	private String tpLogin;

	@ManagedProperty("#{usuarioSessao}")
	private UsuarioSessao usuarioSessao;

	@ManagedProperty("#{loginService}")
	private LoginService loginService;

	@ManagedProperty("#{facesUtils}")
	private FacesUtils facesUtils;

	public String logar(){
		Usuario usuario = loginService.autentica(loginEmail, senha);
		if(usuario != null){
			usuarioSessao.login(usuario);
			return "/pages/home?faces-redirect=true"; // outcome
		}
		facesUtils.adicionaMensagemDeErro("Login ou senha invalida.");
		return null;
	}

	public String preCadastro(){
		return "precadastro";
	}

	public String cadastro(){
		return "cadastro";
	}

	public String sair() {
		usuarioSessao.logout();
		return "login";
	}


	/**
	 * @return the login
	 */
	public String getLoginEmail() {
		return loginEmail;
	}
	/**
	 * @param login the login to set
	 */
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the tpLogin
	 */
	public String getTpLogin() {
		return tpLogin;
	}

	/**
	 * @param tpLogin the tpLogin to set
	 */
	public void setTpLogin(String tpLogin) {
		this.tpLogin = tpLogin;
	}

	/**
	 * @param usuarioSessao the usuarioSessao to set
	 */
	public void setUsuarioSessao(UsuarioSessao usuarioSessao) {
		this.usuarioSessao = usuarioSessao;
	}
	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	/**
	 * @param facesUtils
	 */
	public void setFacesUtils(FacesUtils facesUtils) {
		this.facesUtils = facesUtils;
	}
}