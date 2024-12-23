package com.curso.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.curso.dao.ProductoDAO;
import com.curso.modelo.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet para eliminar producto a partir de un indice como parametro 
 * @author Sergio Castro
 * @version 1.0 2024/12/17
 */
public class EliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO servicio = new ProductoDAO();     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String indexEliminar = request.getParameter("indexEliminar");
		
		if(indexEliminar != null && !indexEliminar.isEmpty()) {
			int index = Integer.parseInt(indexEliminar) ;
						
			Producto p = servicio.findBy(index);
			
			servicio.remove(p);
					
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset=\"UTF-8\">");
	        out.println("<title></title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<p>Se ha eliminado el producto correctamente:</p>");
	        out.println("<p>Nombre: "+p.getNombre()+"</p>");
	        out.println("<p>Categoria: "+p.getCategoria()+"</p>");
	        out.println("<p>Precio: "+p.getPrecio()+"</p>");
	        out.println("<p>Stock: "+p.getStock()+"</p>");
			out.println("<a href='index.html'>Volver al índice</a>");
			out.println("</body>");
			out.println("</html>");
			out.close();						
			
		}else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset=\"UTF-8\">");
	        out.println("<title></title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<p>No se ha podido eliminar el producto.</p>");
			out.println("<a href='index.html'>Volver al índice</a>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
		
	}


}
