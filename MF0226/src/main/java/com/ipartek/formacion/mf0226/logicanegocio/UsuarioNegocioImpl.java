package com.ipartek.formacion.mf0226.logicanegocio;

import java.math.BigDecimal;
import java.util.logging.Logger;

import com.ipartek.formacion.mf0226.accesodatos.ProductoDao;
import com.ipartek.formacion.mf0226.accesodatos.TreemapProductoDao;
import com.ipartek.formacion.mf0226.modelos.Producto;

public class UsuarioNegocioImpl implements UsuarioNegocio {

	private static final Logger log = Logger.getLogger(UsuarioNegocioImpl.class.getName());
	
	private ProductoDao dao = TreemapProductoDao.getInstancia();
	
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

}
