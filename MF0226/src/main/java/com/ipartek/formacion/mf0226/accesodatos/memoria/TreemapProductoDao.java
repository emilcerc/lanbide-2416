package com.ipartek.formacion.mf0226.accesodatos.memoria;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.TreeMap;

import com.ipartek.formacion.mf0226.accesodatos.ProductoDao;
import com.ipartek.formacion.mf0226.entidades.Producto;

public class TreemapProductoDao implements ProductoDao {
	private TreeMap<Long, Producto> productos = new TreeMap<>();
		
	// SINGLETON
	public static TreemapProductoDao getInstancia() { return instancia; }
	private static final TreemapProductoDao instancia = new TreemapProductoDao();
	private TreemapProductoDao() {
		for(int i = 1; i <= 10; i++) {
			productos.put((long)i, Producto.builder()
					.id((long)i)
					.nombre("Producto" + i)
					.precio(new BigDecimal(i + "000"))
					.garantia(LocalDate.of(
							2000+i, i, 2*i))
				.build()
			);
		}
	}
	// FIN SINGLETON
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return productos.get(id);
	}

	@Override
	public Producto insertar(Producto producto) {
		Long id = productos.size() > 0 ? productos.lastKey() + 1L : 1L;
		producto.setId(id);
		
		productos.put(id, producto);
		
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		productos.put(producto.getId(), producto);
		
		return producto;
	}

	@Override
	public void borrar(Long id) {
		productos.remove(id);
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String parteDelNombre) {
		return productos.values().parallelStream()
				.filter(producto -> producto.getNombre().contains(parteDelNombre))
				.toList();
	}

	@Override
	public Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		return productos.values().parallelStream()
				.filter(producto -> producto.getPrecio().compareTo(minimo) >= 0 &&
									producto.getPrecio().compareTo(maximo) <= 0)
				.toList();
	}

}
