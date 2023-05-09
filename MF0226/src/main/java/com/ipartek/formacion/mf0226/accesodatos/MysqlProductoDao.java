package com.ipartek.formacion.mf0226.accesodatos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.ipartek.formacion.mf0226.modelos.Producto;

public class MysqlProductoDao extends BaseDao implements ProductoDao {

	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, garantia) VALUES (?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, garantia=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";
	private static final String SQL_PRECIO = SQL_SELECT + " WHERE precio BETWEEN ? AND ?";
	private static final String SQL_NOMBRE = SQL_SELECT + " WHERE nombre LIKE ?";

	@Override
	public Iterable<Producto> obtenerTodos() {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {

			Collection<Producto> productos = new ArrayList<>();
			Producto producto;

			while (rs.next()) {
				producto = Producto.builder().id(rs.getLong("id")).nombre(rs.getString("nombre"))
						.precio(rs.getBigDecimal("precio")).garantia(dateToLocalDate(rs.getDate("garantia"))).build();

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los productos", e);
		}
	}

	@Override
	public Producto obtenerPorId(Long id) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {

			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			Producto producto = null;

			if (rs.next()) {
				producto = Producto.builder().id(rs.getLong("id")).nombre(rs.getString("nombre"))
						.precio(rs.getBigDecimal("precio")).garantia(dateToLocalDate(rs.getDate("garantia"))).build();
			}

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto id " + id, e);
		}
	}

	@Override
	public Producto insertar(Producto producto) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			
			if(producto.getGarantia() != null) {
				pst.setDate(3, java.sql.Date.valueOf(producto.getGarantia()));
			} else {
				pst.setDate(3, null);
			}

			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			rs.next();
			
			Long id = rs.getLong(1);
			
			producto.setId(id);
			
			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el producto " + producto, e);
		}
	}

	@Override
	public Producto modificar(Producto producto) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			
			if(producto.getGarantia() != null) {
				pst.setDate(3, java.sql.Date.valueOf(producto.getGarantia()));
			} else {
				pst.setDate(3, null);
			}
			
			pst.setLong(4, producto.getId());

			int numeroRegistros = pst.executeUpdate();
			
			if(numeroRegistros != 1) {
				throw new AccesoDatosException("No se ha encontrado el registro a modificar");
			}
			
			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el producto " + producto, e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setLong(1, id);

			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto id " + id, e);
		}
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String parteDelNombre) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_NOMBRE);
				) {
			
			pst.setString(1, "%" + parteDelNombre + "%");
			
			ResultSet rs = pst.executeQuery();

			Collection<Producto> productos = new ArrayList<>();
			Producto producto;

			while (rs.next()) {
				producto = Producto.builder().id(rs.getLong("id")).nombre(rs.getString("nombre"))
						.precio(rs.getBigDecimal("precio")).garantia(dateToLocalDate(rs.getDate("garantia"))).build();

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener los productos con nombre " + parteDelNombre, e);
		}

	}

	@Override
	public Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_PRECIO);
				) {

			pst.setBigDecimal(1, minimo);
			pst.setBigDecimal(2, maximo);
			
			ResultSet rs = pst.executeQuery();
			
			Collection<Producto> productos = new ArrayList<>();
			Producto producto;

			while (rs.next()) {
				producto = Producto.builder().id(rs.getLong("id")).nombre(rs.getString("nombre"))
						.precio(rs.getBigDecimal("precio")).garantia(dateToLocalDate(rs.getDate("garantia"))).build();

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los productos", e);
		}

	}
}
