package com.ipartek.formacion.mf0226.accesodatos;

import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;

public class FabricaDaoImpl implements FabricaDao {
	private ProductoDao productoDao;
	private UsuarioDao usuarioDao;
	
	public FabricaDaoImpl() {
		Properties props = new Properties();
		try {
			props.load(new FileReader("/Users/javierlete/git/lanbide-2416/MF0226/src/main/resources/fabricadao.properties"));
			
			String propProductoDao = props.getProperty("productodao");
			String propUsuarioDao = props.getProperty("usuariodao");
			
			productoDao = (ProductoDao) Class.forName(propProductoDao).getDeclaredConstructor().newInstance();
			usuarioDao = (UsuarioDao) Class.forName(propUsuarioDao).getDeclaredConstructor().newInstance();
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido abrir la configuración de la fábrica", e);
		} catch (Exception e) {
			throw new AccesoDatosException("No se han podido crear los objetos para la fábrica", e);
		}
	}
	
	@Override
	public ProductoDao obtenerProductoDao() {
		return productoDao;
	}

	@Override
	public UsuarioDao obtenerUsuarioDao() {
		return usuarioDao;
	}

}
