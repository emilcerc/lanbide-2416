package com.ipartek.formacion.mf0226.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Producto {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private LocalDate garantia;
	
	public Producto(Long id, String nombre, BigDecimal precio, LocalDate garantia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.garantia = garantia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public LocalDate getGarantia() {
		return garantia;
	}

	public void setGarantia(LocalDate garantia) {
		this.garantia = garantia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(garantia, id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(garantia, other.garantia) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", garantia=" + garantia + "]";
	}
	
	
}
