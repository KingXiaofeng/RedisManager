package com.mauersu.filter;

import com.mauersu.util.RedisApplication;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器
 */
public class CleanContextFilter extends RedisApplication implements Filter  {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String contentPath = filterConfig.getServletContext().getContextPath();
		BASE_PATH = contentPath;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		chain.doFilter(request, response);
		cleanContext();
	}

	private void cleanContext() {
		redisConnectionDbIndex.set(0);
	}

	@Override
	public void destroy() {
		
	}

}
