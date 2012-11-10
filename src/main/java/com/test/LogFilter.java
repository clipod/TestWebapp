package com.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter{

	public static final Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);
	
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.info("Filter init parameter" + filterConfig.getInitParameter("test-param"));
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOGGER.info("Remote address of the request "+request.getRemoteAddr());
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}
	

}
