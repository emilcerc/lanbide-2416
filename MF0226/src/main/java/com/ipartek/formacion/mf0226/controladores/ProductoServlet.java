package com.ipartek.formacion.mf0226.controladores;

import java.io.IOException;

import com.ipartek.formacion.mf0226.logicanegocio.UsuarioNegocio;
import com.ipartek.formacion.mf0226.logicanegocio.UsuarioNegocioImpl;
import com.ipartek.formacion.mf0226.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/producto")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsuarioNegocio negocio = new UsuarioNegocioImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parId = request.getParameter("id");
		
		if(parId != null) {
			Long id = Long.parseLong(parId);
			
			Producto producto = negocio.detalle(id);
			
			request.setAttribute("producto", producto);
		}
		
		request.getRequestDispatcher("/WEB-INF/vistas/producto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
