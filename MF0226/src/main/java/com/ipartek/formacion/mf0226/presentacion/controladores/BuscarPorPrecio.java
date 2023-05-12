package com.ipartek.formacion.mf0226.presentacion.controladores;

import java.io.IOException;
import java.math.BigDecimal;

import com.ipartek.formacion.mf0226.entidades.Producto;
import com.ipartek.formacion.mf0226.logicanegocio.UsuarioNegocio;
import com.ipartek.formacion.mf0226.logicanegocio.UsuarioNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buscar-precio")
public class BuscarPorPrecio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsuarioNegocio negocio = new UsuarioNegocioImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String min = request.getParameter("minimo");
		String max = request.getParameter("maximo");
		
		BigDecimal minimo = new BigDecimal(min);
		BigDecimal maximo = new BigDecimal(max);
		
		Iterable<Producto> productos = negocio.buscarPorPrecios(minimo, maximo);
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
