<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curso.modelo.Producto" %>
<%@ page import="com.curso.dao.ProductoDAO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar productos</title>
</head>
<body>

<%
ProductoDAO pdao = new ProductoDAO();
List<Producto> productos = pdao.findAll();

%>

<h1>Modificar productos</h1>

<%
for(int i=0; i< productos.size(); i++){

%>

<p> Nombre: <%= productos.get(i).getNombre() %> --- Categoria: <%= productos.get(i).getCategoria() %>
--- Precio: <%= productos.get(i).getPrecio() %> --- Stock: <%= productos.get(i).getStock() %>--- <a href="ModificarServlet?indexModificar=<%= productos.get(i).getId() %>">Modificar</a></p><br>
		
<%} %>

<a href='index.html'>Volver al índice.</a>


</body>
</html>