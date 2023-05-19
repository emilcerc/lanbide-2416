package com.ipartek.formacion.musicamvc.presentacion.controladores;

import static com.ipartek.formacion.musicamvc.presentacion.controladores.Globales.RAIZ;

import java.io.IOException;

import com.ipartek.formacion.musicamvc.entidades.Cancion;
import com.ipartek.formacion.musicamvc.entidades.Estilo;
import com.ipartek.formacion.musicamvc.logicanegocio.UsuarioNegocio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuario/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio)request.getSession().getAttribute("usuarioNegocio");
		
		Iterable<Cancion> canciones = usuarioNegocio.obtenerCancionesUsuario();
		Iterable<Estilo> estilos = usuarioNegocio.obtenerEstilos();
		
		request.setAttribute("canciones", canciones);
		request.setAttribute("estilos", estilos);
		request.getRequestDispatcher(RAIZ + "/principal.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio)request.getSession().getAttribute("usuarioNegocio");
		
		String titulo = request.getParameter("titulo");
		String grupo = request.getParameter("grupo");
		String parEstilo = request.getParameter("estilo");
		String enlace = request.getParameter("enlace");
		
		Estilo estilo = Estilo.builder().id(Long.parseLong(parEstilo)).build();
		
		Cancion cancion = Cancion.builder().titulo(titulo).grupo(grupo).estilo(estilo).enlace(enlace).build();
		
		usuarioNegocio.insertarCancion(cancion);
		
		response.sendRedirect(request.getContextPath() + "/usuario/principal");
	}

}
