package com.curso.servlet;

import java.io.IOException;

import com.curso.dao.ProductoDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet para listar productos 
 * @author Sergio Castro
 * @version 1.0 2024/12/17
 */
public class ListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO servicio = new ProductoDAO();
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
		request.setAttribute("productos", servicio.findAll());
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
		dispatcher.forward(request, response);
		
	}

	

}
