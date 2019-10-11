package br.com.tratamentovip.core.business.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.tratamentovip.core.web.bean.UsuarioSessao;



@WebFilter(urlPatterns="/*")
public class SecurityFilter implements Filter {

	private static final String LOGIN_PAGE = "/pages/login.xhtml";
	private static final String FACES_RESOURCES = "/javax.faces.resource";
	private static final String PRE_CADASTRO_RESOURCES = "/pages/pre_cadastro.xhtml";
	private static final String CADASTRO_RESOURCES = "/pages/cadastro.xhtml";
	private static final String WS_RESTFUL = "/ws-rest";
	
	@Override
	public void init(FilterConfig config) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        if (isUrlPermitida(request)
        			|| isUsuarioLogado(request)) {
        		chain.doFilter(req, res);
        } else {
        		response.sendRedirect(request.getContextPath() + LOGIN_PAGE);
        }
	}
	
	private boolean isUsuarioLogado(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UsuarioSessao usuarioSessao = (UsuarioSessao) session.getAttribute("usuarioSessao");
		return usuarioSessao != null
        			&& usuarioSessao.isLogado();
	}

	private boolean isUrlPermitida(HttpServletRequest request) {
		String path = request.getServletPath();
		return path.equals(LOGIN_PAGE)
				|| path.startsWith(FACES_RESOURCES)
				|| path.equals(PRE_CADASTRO_RESOURCES)
				|| path.equals(CADASTRO_RESOURCES)
				|| path.startsWith(WS_RESTFUL);
	}

	@Override
	public void destroy() {}

}
