package es.indra.academia.controller.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SeguridadFilter
 */
//@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/admin/*" })
public class SeguridadFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SeguridadFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest peticion = (HttpServletRequest) request;
		HttpServletResponse respuesta = (HttpServletResponse) response;
		HttpSession sesion = peticion.getSession(true);
		String identificador = (String) sesion.getAttribute("identificado");
		if (identificador != null && identificador.equals("si")) {
			chain.doFilter(request, response);
		} else {
			respuesta.sendRedirect(peticion.getContextPath() + "/inadex.jsp");

		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
