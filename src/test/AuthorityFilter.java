package test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "authority", urlPatterns = "/*", initParams = {
		@WebInitParam(name = "encoding", value = "utf-8"), @WebInitParam(name = "loginPage", value = "/login.jsp"),
		@WebInitParam(name = "prologin", value = "/login") })
public class AuthorityFilter implements Filter {
	private FilterConfig config;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@Override
	public void destroy() {
		config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String encoding = config.getInitParameter("encoding");
		String loginPage = config.getInitParameter("loginPage");
		String prologin = config.getInitParameter("prologin");

		request.setCharacterEncoding(encoding);
		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpSession session = hRequest.getSession(true);
		String path = hRequest.getServletPath();

		if (session.getAttribute("name") == null && !path.endsWith(loginPage) && !path.endsWith(prologin)) {
			hRequest.setAttribute("tip", "你还没有登陆");
			hRequest.getRequestDispatcher(loginPage).forward(request, response);
		}else {
			chain.doFilter(request, response);
		}

	}

}
