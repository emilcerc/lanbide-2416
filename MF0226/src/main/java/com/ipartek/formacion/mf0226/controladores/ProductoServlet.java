package com.ipartek.formacion.mf0226.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.mf0226.logicanegocio.AdministradorNegocio;
import com.ipartek.formacion.mf0226.logicanegocio.AdministradorNegocioImpl;
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
	private AdministradorNegocio adminNegocio = new AdministradorNegocioImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parId = request.getParameter("id");

		if (parId != null) {
			Long id = Long.parseLong(parId);

			Producto producto = negocio.detalle(id);

			request.setAttribute("producto", producto);
		}

		request.getRequestDispatcher("/WEB-INF/vistas/producto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String parPrecio = request.getParameter("precio");
		String parGarantia = request.getParameter("garantia");

		Long id = null;

		if (parId != null && !parId.isBlank()) {
			id = Long.parseLong(parId);
		}
		
		BigDecimal precio = new BigDecimal(parPrecio);
		LocalDate garantia = LocalDate.parse(parGarantia);

		Producto producto = Producto.builder().id(id).nombre(nombre).precio(precio).garantia(garantia).build();

		if(producto.getId() == null) {
			adminNegocio.agregarProducto(producto);
		} else {
			adminNegocio.modificarProducto(producto);
		}
		
		response.sendRedirect("index");
	}

}
