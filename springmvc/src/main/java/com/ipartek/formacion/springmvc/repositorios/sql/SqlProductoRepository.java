package com.ipartek.formacion.springmvc.repositorios.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.springmvc.entidades.Producto;
import com.ipartek.formacion.springmvc.repositorios.ProductoRepository;

@Repository
public class SqlProductoRepository implements ProductoRepository {
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return jdbc.query("SELECT * FROM productos",
				new BeanPropertyRowMapper<Producto>());
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * FROM productos WHERE id = ?", 
				new BeanPropertyRowMapper<Producto>(), //(rs, numFila) -> new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"), rs.getDate("caducidad").toLocalDate()),
				id);
	}

	@Override
	public Producto insertar(Producto producto) {
		jdbc.update("INSERT INTO productos (nombre, precio, caducidad) VALUES (?,?,?)",
				producto.getNombre(), producto.getPrecio(), producto.getCaducidad());
		// No incluye el id nuevo en el producto
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		jdbc.update("UPDATE productos SET nombre=?, precio=?, caducidad=? WHERE id = ?",
				producto.getNombre(), producto.getPrecio(), producto.getCaducidad(), producto.getId());
		
		return producto;
	}

	@Override
	public void borrar(Long id) {
		jdbc.update("DELETE FROM productos WHERE id = ?", id);		
	}

}
