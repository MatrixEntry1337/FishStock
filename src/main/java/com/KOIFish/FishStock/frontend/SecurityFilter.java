package com.KOIFish.FishStock.frontend;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter implements Filter {



	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String ruri = request.getRequestURL().toString();
		
		if (ruri.endsWith("/app/home")) {
			if (request.getSession().getAttribute("user_obj") != null) {
				((HttpServletResponse) response).sendRedirect("/FishStock/!#/user_account/home");
			}
			else {
				chain.doFilter(request, response);
			}
			
		} else if (ruri.endsWith("/user_account/home")) {
			if (request.getSession().getAttribute("user_obj") != null) {
				chain.doFilter(request, response);
			}
			else {
				((HttpServletResponse) response).sendRedirect("/FishStock/!#/app/home");
			}
		}
		else {
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}

}
