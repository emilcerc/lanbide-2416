package com.ipartek.formacion.musicamvc.presentacion.controladores;

import static com.ipartek.formacion.musicamvc.presentacion.controladores.Globales.ANONIMO_NEGOCIO;
import static com.ipartek.formacion.musicamvc.presentacion.controladores.Globales.RAIZ;

import java.io.IOException;

import com.ipartek.formacion.musicamvc.entidades.Usuario;
import com.ipartek.formacion.musicamvc.logicanegocio.UsuarioNegocio;
import com.ipartek.formacion.musicamvc.logicanegocio.UsuarioNegocioImpl;
import com.ipartek.formacion.musicamvc.presentacion.modelos.Alerta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(RAIZ + "/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuarioLogin = Usuario.builder().email(email).password(password).build();
		
		Usuario usuarioAutenticado = ANONIMO_NEGOCIO.autenticar(usuarioLogin);
		
		if(usuarioAutenticado == null) {
			Alerta alerta = Alerta.builder().mensaje("El usuario o la contraseña son incorrectos").nivel("danger").build();
			
			request.setAttribute("usuario", usuarioLogin);
			request.setAttribute("alerta", alerta);
			
			request.getRequestDispatcher(RAIZ + "/login.jsp").forward(request, response);
		} else {
			UsuarioNegocio usuarioNegocio = new UsuarioNegocioImpl(usuarioAutenticado.getId());
			
			HttpSession session = request.getSession();
			
			session.setAttribute("usuario", usuarioAutenticado);
			session.setAttribute("usuarioNegocio", usuarioNegocio);
			
			response.sendRedirect(request.getContextPath() + "/usuario/principal");
		}
	}

}
