package com.ipartek.formacion.mf0226.jaxrs;

import com.ipartek.formacion.mf0226.entidades.Producto;
import com.ipartek.formacion.mf0226.logicanegocio.AdministradorNegocio;
import com.ipartek.formacion.mf0226.logicanegocio.AdministradorNegocioImpl;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
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
		return NEGOCIO.detalle(id);
	}
	
	@POST
	public Producto post(Producto producto) {
		return NEGOCIO.agregarProducto(producto);
	}
	
	@PUT
	@Path("{id}")
	public Producto put(@PathParam("id") Long id, Producto producto) {
		return NEGOCIO.modificarProducto(producto);
	}
	
	@DELETE
	@Path("{id}")
	public void borrar(@PathParam("id") Long id) {
		NEGOCIO.borrarProducto(id);
	}
}
