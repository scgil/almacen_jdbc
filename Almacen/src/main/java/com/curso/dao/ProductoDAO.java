package com.curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.curso.conexion.ConexionBD;
import com.curso.modelo.Producto;
import com.curso.modelo.Producto.Categoria;

/**
 * La clase ProductoDAO implementa la interfaz Producto.
 * Se implementan las operaciones necesarias para gestionar los Productos en base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/19
 */
public class ProductoDAO implements IProducto {
	
	private static final String SAVE_QUERY = "INSERT INTO productos (nombre, categoria, precio, stock) VALUES(?,?,?,?)";
	private static final String UPDATE_QUERY = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE id = ?";
	private static final String REMOVE_QUERY = "DELETE FROM productos WHERE id = ?";
	private static final String FINDBY_ID_QUERY = "SELECT * FROM productos WHERE id = ?";
	private static final String FINDALL_QUERY = "SELECT * FROM productos";
	private static final String FINDBY_CATEGORIA_QUERY = "SELECT * FROM productos WHERE categoria = ?";
	
	
	private Connection conex = null;

	@Override
	public void save(Producto producto) {
		if(producto != null) {
			ConexionBD cbd = new ConexionBD();
			conex = cbd.conexion();
			if(conex != null) {
				System.out.println("Conectado correctamente");
				try (PreparedStatement sentencia = conex.prepareStatement(SAVE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
					sentencia.setString(1, producto.getNombre());
					sentencia.setString(2, producto.getCategoria().name());
					sentencia.setDouble(3, producto.getPrecio());
					sentencia.setInt(4, producto.getStock());
					int filas = sentencia.executeUpdate();
					if(filas >0) {
						ResultSet rs = sentencia.getGeneratedKeys();
						if(rs.next()) {
							int id = rs.getInt(1);
							System.out.println("Registro insertado");
							System.out.println("ID generado: " + id);
						}
					}else {	
						System.out.println("El registro no se pudo insertar");
					
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}else {
				System.out.println("No se pudo conectar a la base de datos.");
			}
		}else {
			System.out.println("El objeto es null");
		}
		
		

	}

	@Override
	public void update(Producto producto) {
		if(producto!=null) {
			ConexionBD cbd = new ConexionBD();
			conex = cbd.conexion();
			if(conex != null) {
				System.out.println("Conectado correctamente");
				try (PreparedStatement sentencia = conex.prepareStatement(UPDATE_QUERY)) {
					sentencia.setString(1, producto.getNombre());
					sentencia.setString(2, producto.getCategoria().name());
					sentencia.setDouble(3, producto.getPrecio());
					sentencia.setInt(4, producto.getStock());
					sentencia.setInt(5, producto.getId());
					
					System.out.println("Registro ha actualizar: "+producto.getId()+"|"+producto.getNombre()+"|"+ producto.getCategoria()+"|"+producto.getPrecio()+"|"+producto.getStock());
					
					int filas = sentencia.executeUpdate();
					if(filas >0) {
						System.out.println("El registro ha sido actualizado");
						
					}else {
						System.out.println("El registro no se pudo actualizar");
						
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}else {
				System.out.println("No se ha podido conectar a la base de datos");
			}
		}else {
			System.out.println("El objeto es null");
		}

	}

	@Override
	public void remove(Producto producto) {
		if(producto!=null) {
			ConexionBD cbd = new ConexionBD();
			conex = cbd.conexion();
			if(conex != null) {
				System.out.println("Conectado correctamente");
				try (PreparedStatement sentencia = conex.prepareStatement(REMOVE_QUERY)) {
					sentencia.setInt(1, producto.getId());
					int filas = sentencia.executeUpdate();
					if(filas >0) {
						System.out.println("El registro ha sido borrado");
						
					}else {
						System.out.println("El registro no se pudo borrar");
						
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}else {
				System.out.println("No se ha podido conectar a la base de datos");
			}
		}else {
			System.out.println("El objeto es null");
		}
		

	}

	@Override
	public Producto findBy(int id) {
			ConexionBD cbd = new ConexionBD();
			conex = cbd.conexion();
			Producto p = null;
			
			if(conex != null) {
				System.out.println("Conectado correctamente");
				try (PreparedStatement sentencia = conex.prepareStatement(FINDBY_ID_QUERY)) {
					
					sentencia.setInt(1, id);
					ResultSet rs = sentencia.executeQuery();
					if(rs.next()) {
						int idProducto = rs.getInt("id");
						String nombre = rs.getString("nombre");
						Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
						double precio = rs.getDouble("precio");
						int  stock = rs.getInt("stock");
						System.out.println("Registro recuperado: "+idProducto+"|"+nombre+"|"+ categoria+"|"+precio+"|"+stock);
						p = new Producto(idProducto, nombre, categoria, precio, stock);
						
					}else {
						System.out.println("No se ha recuperado ningún registro");
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}else {
				System.out.println("No se ha podido conectar a la base de datos");
			}
		
		return p;
	}

	@Override
	public List<Producto> findAll() {
		ConexionBD cbd = new ConexionBD();
		conex = cbd.conexion();
		List<Producto> productos = new ArrayList<>();
		
		if(conex != null) {
			System.out.println("Conectado correctamente");
			try (PreparedStatement sentencia = conex.prepareStatement(FINDALL_QUERY)) {
				
				ResultSet rs = sentencia.executeQuery();
				while(rs.next()) {
					int id_producto = rs.getInt("id");
					String nombre = rs.getString("nombre");
					Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
					double precio = rs.getDouble("precio");
					int  stock = rs.getInt("stock");
					System.out.println("Registro recuperado: "+id_producto+"|"+nombre+"|"+ categoria+"|"+precio+"|"+stock);
					Producto p = new Producto(id_producto, nombre, categoria, precio, stock);
					productos.add(p);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else {
			System.out.println("No se ha podido conectar a la base de datos");
		}
	
	return productos;
	}
	
	@Override
	public List<Producto> findByCategoria(String categoria) {
		ConexionBD cbd = new ConexionBD();
		conex = cbd.conexion();
		List<Producto> productos = new ArrayList<>();
		
		if(conex != null) {
			System.out.println("Conectado correctamente");
			try (PreparedStatement sentencia = conex.prepareStatement(FINDBY_CATEGORIA_QUERY)) {
				
				sentencia.setString(1, categoria);
				
				ResultSet rs = sentencia.executeQuery();
				while(rs.next()) {
					int idProducto = rs.getInt("id");
					String nombre = rs.getString("nombre");
					Categoria categoriaProducto = Categoria.valueOf(rs.getString("categoria"));
					double precio = rs.getDouble("precio");
					int  stock = rs.getInt("stock");
					System.out.println("Registro recuperado: "+idProducto+"|"+nombre+"|"+ categoriaProducto+"|"+precio+"|"+stock);
					Producto p = new Producto(idProducto, nombre, categoriaProducto, precio, stock);
					productos.add(p);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else {
			System.out.println("No se ha podido conectar a la base de datos");
		}
	
	return productos;
	}
	
	
}
