<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curso.modelo.Producto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de productos</title>
</head>
<body>

<%
List<Producto> productos = (List<Producto>)request.getAttribute("productos");

%>

<h1>Productos</h1>

<%
for(Producto producto: productos){

%>

<p> Nombre: <%= producto.getNombre() %> --- Categoria: <%= producto.getCategoria() %> --- Precio: <%= producto.getPrecio() %> --- Stock: <%= producto.getStock() %></p><br>
		
<%} %>

<a href='index.html'>Volver al índice.</a>


</body>
</html>