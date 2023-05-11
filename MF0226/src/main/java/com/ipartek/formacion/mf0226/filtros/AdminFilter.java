package com.ipartek.formacion.mf0226.filtros;

import java.io.IOException;

import com.ipartek.formacion.mf0226.modelos.Usuario;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 5809621755117048578L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null && usuario.getRol().getNombre().equals("ADMIN")) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("mensaje", "Necesitas ser administrador para entrar en esta zona");
			
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}
}
