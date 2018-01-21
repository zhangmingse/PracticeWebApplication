package test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="log",urlPatterns= {"/*"},asyncSupported=true)
public class LogFilter implements Filter{
	private FilterConfig config;
	public void init(FilterConfig config) {
		this.config = config;
	}
	@Override
	public void destroy() {
		config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Logfilter doFilter");
		ServletContext context = this.config.getServletContext();
		long before = System.currentTimeMillis();
		System.out.println("开始过滤");
		HttpServletRequest hRequest = (HttpServletRequest)request;
		System.out.println("截获用户请求url" + hRequest.getServletPath());
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		System.out.println("过滤结束");
		System.out.println("请求被定位到:" + hRequest.getRequestURI() + "  耗时:" + (after-before)+"ms");
		
		
		
	}

}
