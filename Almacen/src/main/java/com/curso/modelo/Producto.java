package com.curso.modelo;

import java.util.Objects;
/**
 * La clase Producto representa un Producto.
 * @author Sergio Castro
 * @version 1.0 2024/12/19
 */
public class Producto {
	public enum Categoria{
		ELECTRODOMESTICOS, TEXTIL
	}
	private int id;
	private String nombre;
	private Categoria categoria;
	private double precio;
	private int stock;
	
	public Producto(String nombre, Categoria categoria, double precio, int stock) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.stock = stock;
	}
	public Producto(int id, String nombre, Categoria categoria, double precio, int stock) {
		this(nombre, categoria, precio, stock);
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public int setId(int id) {
		return this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}		

}