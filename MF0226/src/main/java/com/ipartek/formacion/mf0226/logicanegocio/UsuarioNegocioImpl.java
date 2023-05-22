package com.ipartek.formacion.mf0226.logicanegocio;

import java.math.BigDecimal;
import java.util.logging.Logger;

import com.ipartek.formacion.mf0226.accesodatos.ProductoDao;
import com.ipartek.formacion.mf0226.accesodatos.UsuarioDao;
import com.ipartek.formacion.mf0226.entidades.Producto;
import com.ipartek.formacion.mf0226.entidades.Usuario;

public class UsuarioNegocioImpl implements UsuarioNegocio {

	private static final Logger log = Logger.getLogger(UsuarioNegocioImpl.class.getName());
	
	private ProductoDao dao = Globales.FABRICA_DAO.obtenerProductoDao();
	private UsuarioDao daoUsuario = Globales.FABRICA_DAO.obtenerUsuarioDao();
	
	@Override
	public Iterable<Producto> listado() {
		log.info("LISTADO");
		return dao.obtenerTodos();
	}

	@Override
	public Producto detalle(Long id) {
		log.info("DETALLE: " + id);
		return dao.obtenerPorId(id);
	}

	@Override
	public Iterable<Producto> buscarPorPrecios(BigDecimal minimo, BigDecimal maximo) {
		log.info("PRECIOS ENTRE " + minimo + " y " + maximo);
		return dao.buscarPorPrecio(minimo, maximo);
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String parteDelNombre) {
		log.info("BUSCAR POR NOMBRE: " + parteDelNombre);
		return dao.buscarPorNombre(parteDelNombre);
	}

	@Override
	public Usuario autenticarUsuario(Usuario usuarioLogin) {
		Usuario usuarioObtenido = daoUsuario.obtenerPorEmail(usuarioLogin.getEmail());
		
		if(usuarioObtenido == null) {
			return null;
		}
		
		if(usuarioObtenido.getPassword().equals(usuarioLogin.getPassword())) {
			return usuarioObtenido;
		} else {
			return null;
		}
	}

	@Override
	public Iterable<Producto> buscar(String nombre, BigDecimal minimo, BigDecimal maximo) {
		log.info(String.format("BUSCAR: %s, %s, %s", nombre, minimo, maximo));
		return dao.buscar(nombre, minimo, maximo);
	}

}
