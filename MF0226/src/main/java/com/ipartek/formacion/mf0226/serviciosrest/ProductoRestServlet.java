package com.ipartek.formacion.mf0226.serviciosrest;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ipartek.formacion.mf0226.entidades.Producto;
import com.ipartek.formacion.mf0226.logicanegocio.AdministradorNegocio;
import com.ipartek.formacion.mf0226.logicanegocio.AdministradorNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/productos/*")
public class ProductoRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final ObjectMapper MAPPER = new ObjectMapper();

	private static final AdministradorNegocio NEGOCIO = new AdministradorNegocioImpl(); 

	static {
		MAPPER.registerModule(new JavaTimeModule());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Long id = getId(request);

		if (id == null) {
			Iterable<Producto> productos = NEGOCIO.listado();

			MAPPER.writeValue(out, productos);
		} else {
			Producto producto = NEGOCIO.detalle(id);
			
			MAPPER.writeValue(out, producto);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream in = request.getInputStream();
		
		Producto producto = MAPPER.readValue(in, Producto.class);
		
		NEGOCIO.agregarProducto(producto);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream in = request.getInputStream();
		
		Producto producto = MAPPER.readValue(in, Producto.class);
		
		NEGOCIO.modificarProducto(producto);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = getId(request);
		
		NEGOCIO.borrarProducto(id);
	}

	private static Long getId(HttpServletRequest request) {
		String pathInfo = request.getPathInfo();

		if (pathInfo == null || pathInfo != null && pathInfo.trim().length() <= 1) {
			return null;
		}

		Long id = Long.parseLong(pathInfo.substring(1));

		return id;
	}
}
