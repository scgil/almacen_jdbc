package com.curso.dao;

import java.util.List;

import com.curso.modelo.Producto;

/**
 * La interfaz IProducto ofrece operaciones sobre Producto.
 * Ofrece operacione para guardar, actualizar, eliminar, encontrar por id y listar todos los productos y listar por categoria.
 * @author Sergio Castro
 * @version 1.0 2024/12/19
 */

public interface IProducto {
	public void save(Producto producto);

	public void update(Producto producto);

	public void remove(Producto producto);

	public Producto findBy(int id);

	public List<Producto> findAll();
	
	public List<Producto> findByCategoria(String categoria);
		



}
