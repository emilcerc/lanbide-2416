package com.ipartek.formacion.mf0226.logicanegocio;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ipartek.formacion.mf0226.accesodatos.MysqlProductoDao;
import com.ipartek.formacion.mf0226.accesodatos.ProductoDao;
import com.ipartek.formacion.mf0226.modelos.Producto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.java.Log;

@Log
public class AdministradorNegocioImpl extends UsuarioNegocioImpl implements AdministradorNegocio {

	private ProductoDao dao = new MysqlProductoDao();

	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Validator validator = factory.getValidator();

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

	@Override
	public Map<String, String> validarProducto(Producto producto) {
		Set<ConstraintViolation<Producto>> validaciones = validator.validate(producto);

		Map<String, String> errores = new HashMap<>();

		// validaciones.forEach(validacion ->
		// errores.put(validacion.getPropertyPath().toString(),
		// validacion.getMessage()));

		String clave;
		String valor;

		for (ConstraintViolation<Producto> validacion : validaciones) {
			clave = validacion.getPropertyPath().toString();
			valor = validacion.getMessage();

			errores.put(clave, valor);
		}

		log.info(errores.toString());
		
		return errores;
	}

}
