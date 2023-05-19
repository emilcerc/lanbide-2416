package com.ipartek.formacion.musicamvc.presentacion.filtros;

import static com.ipartek.formacion.musicamvc.presentacion.controladores.Globales.RAIZ;

import java.io.IOException;

import com.ipartek.formacion.musicamvc.entidades.Usuario;
import com.ipartek.formacion.musicamvc.presentacion.modelos.Alerta;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter("/usuario/*")
public class UsuarioFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 7910136494253093518L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario == null) {
			Alerta alerta = Alerta.builder().mensaje("Debes estar logueado para usar la aplicación").nivel("danger")
					.build();
			req.setAttribute("alerta", alerta);
			req.getRequestDispatcher(RAIZ + "/login.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

}
