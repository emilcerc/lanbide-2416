package com.ipartek.formacion.musicamvc.jaxrs;

import com.ipartek.formacion.musicamvc.entidades.Cancion;
import com.ipartek.formacion.musicamvc.logicanegocio.UsuarioNegocio;
import com.ipartek.formacion.musicamvc.logicanegocio.UsuarioNegocioImpl;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("canciones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CancionesRest {

	private UsuarioNegocio usuarioNegocio;

	@GET
	@Path("{idUsuario}")
	public Iterable<Cancion> canciones(@PathParam("idUsuario") Long idUsuario) {
		usuarioNegocio = new UsuarioNegocioImpl(idUsuario);
		return usuarioNegocio.obtenerCancionesUsuario();
	}

	@POST
	public Cancion post(Cancion cancion) {
		usuarioNegocio = new UsuarioNegocioImpl(cancion.getUsuario().getId());
		return usuarioNegocio.insertarCancion(cancion);
	}
}
