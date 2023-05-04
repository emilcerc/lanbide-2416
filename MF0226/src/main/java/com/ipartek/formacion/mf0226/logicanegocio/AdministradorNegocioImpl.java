package com.ipartek.formacion.mf0226.logicanegocio;

import com.ipartek.formacion.mf0226.accesodatos.ProductoDao;
import com.ipartek.formacion.mf0226.accesodatos.TreemapProductoDao;
import com.ipartek.formacion.mf0226.modelos.Producto;

import lombok.extern.java.Log;

@Log
public class AdministradorNegocioImpl extends UsuarioNegocioImpl implements AdministradorNegocio {

	private ProductoDao dao = TreemapProductoDao.getInstancia();
	
	@Override
	public Producto agregarProducto(Producto producto) {
		log.info("AGREGAR: " + producto);
		dao.insertar(producto);
		
		return producto;
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		log.info("MODIFICAR: " + producto);
		dao.modificar(producto);
		
		return producto;
	}

	@Override
	public void borrarProducto(Long id) {
		log.info("BORRAR: " + id);
		dao.borrar(id);
	}

}
