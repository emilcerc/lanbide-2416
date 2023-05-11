package com.ipartek.formacion.mf0226.controladores;

import java.io.IOException;

import com.ipartek.formacion.mf0226.logicanegocio.UsuarioNegocio;
import com.ipartek.formacion.mf0226.logicanegocio.UsuarioNegocioImpl;
import com.ipartek.formacion.mf0226.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioNegocio negocio = new UsuarioNegocioImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Usuario usuarioLogin = Usuario.builder().email(email).password(password).build();

		Usuario usuarioAutenticado = negocio.autenticarUsuario(usuarioLogin);
		
		if(usuarioAutenticado != null) {
			request.getSession().setAttribute("usuario", usuarioAutenticado);
			
			response.sendRedirect(request.getContextPath() + "/index");
		} else {
			request.setAttribute("usuario", usuarioLogin);
			request.setAttribute("mensaje", "El usuario o la contraseña son incorrectas");
			
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}

}
