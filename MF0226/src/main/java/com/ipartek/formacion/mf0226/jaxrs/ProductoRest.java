package com.ipartek.formacion.mf0226.jaxrs;

import com.ipartek.formacion.mf0226.entidades.Producto;
import com.ipartek.formacion.mf0226.logicanegocio.AdministradorNegocio;
import com.ipartek.formacion.mf0226.logicanegocio.AdministradorNegocioImpl;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

@Path("productos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoRest {
	private static final AdministradorNegocio NEGOCIO = new AdministradorNegocioImpl(); 

	@GET
	public Iterable<Producto> get() {
		return NEGOCIO.listado();
	}
	
	@GET
	@Path("{id}")
	public Producto getPorId(@PathParam("id") Long id) {
		Producto producto = NEGOCIO.detalle(id);
		
		if(producto == null) {
			throw new NotFoundException();
		}
		
		return producto;
	}
	
	@POST
	public Producto post(Producto producto, @Context final HttpServletResponse response) {
		Producto productoRecibido = NEGOCIO.agregarProducto(producto);
		
		response.setStatus(HttpServletResponse.SC_CREATED);
		
		return productoRecibido;
	}
	
	@PUT
	@Path("{id}")
	public Producto put(@PathParam("id") Long id, Producto producto) {
		return NEGOCIO.modificarProducto(producto);
	}
	
	@DELETE
	@Path("{id}")
	public void borrar(@PathParam("id") Long id, @Context final HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		NEGOCIO.borrarProducto(id);
	}
}
