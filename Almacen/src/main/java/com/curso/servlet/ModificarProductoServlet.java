package com.curso.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.curso.dao.ProductoDAO;
import com.curso.modelo.Producto;
import com.curso.modelo.Producto.Categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet para modificar un producto a partir de un indice como parametro
 * @author Sergio Castro
 * @version 1.0 2024/12/17
 */
public class ModificarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO servicio = new ProductoDAO();  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		String precioStr = request.getParameter("precio");
		String stockStr = request.getParameter("stock");
		int indexModificar = Integer.parseInt(request.getParameter("indiceModificar"));
		
		
		
		
		
		if((nombre != null && precioStr != null && stockStr != null) && (!nombre.isEmpty() && !precioStr.isEmpty() && !stockStr.isEmpty())) {
			double precio = Double.parseDouble(precioStr);
			int stock = Integer.parseInt(stockStr) ;
			
			Producto producto = new Producto(indexModificar, nombre, Categoria.valueOf(categoria), precio, stock);
			
			servicio.update(producto);
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset=\"UTF-8\">");
	        out.println("<title></title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<p>Se ha modificado el producto correctamente:</p>");
	        out.println("<p>Nombre: "+nombre+"</p>");
	        out.println("<p>Categoria: "+categoria+"</p>");
	        out.println("<p>Precio: "+precio+"</p>");
	        out.println("<p>Stock: "+stock+"</p>");
			out.println("<a href='index.html'>Volver al índice</a>");
			out.println("</body>");
			out.println("</html>");
			out.close();
			 
					
		}else{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset=\"UTF-8\">");
	        out.println("<title></title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<p>No se ha podido modificar el producto.</p>");
			out.println("<a href='index.html'>Volver al índice</a>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
	}

}
