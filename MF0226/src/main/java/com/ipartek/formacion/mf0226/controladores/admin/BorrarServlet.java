package com.ipartek.formacion.mf0226.controladores.admin;

import java.io.IOException;

import com.ipartek.formacion.mf0226.logicanegocio.AdministradorNegocio;
import com.ipartek.formacion.mf0226.logicanegocio.AdministradorNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/borrar")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AdministradorNegocio negocio = new AdministradorNegocioImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parId = request.getParameter("id");
		
		Long id = Long.parseLong(parId);
		
		negocio.borrarProducto(id);
		
		response.sendRedirect("index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
