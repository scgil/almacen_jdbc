package com.curso.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * La clase FrontControlador representa servlet que actua como controlador de la aplicación.
 * @author Sergio Castro
 * @version 1.0 2024/12/19
 */
public class FrontControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		String urlVista = "/";
		switch (option) {
		case "insertar":
			urlVista = "insertar.jsp";
			break;
		case "eliminar":
			urlVista = "eliminar.jsp";
			break;
		case "modificar":
			urlVista = "modificar.jsp";
			break;
		case "listar":
			urlVista = "ListarServlet";
			break;
		case "buscar":
			urlVista = "buscar.jsp";
			break;
		}
		RequestDispatcher despachador = request.getRequestDispatcher(urlVista);
		despachador.forward(request, response);
		
	
	}



}
