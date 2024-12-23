<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curso.modelo.Producto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado de la busqueda</title>
</head>
<body>

<%

List<Producto> productosCategoria = (List<Producto>) request.getAttribute("categoria");
String categoria = productosCategoria.get(0).getCategoria().name();
%>
<h1>Resultado de la busqueda por la categoria: <%= categoria %></h1>


<%
for(int i=0; i<productosCategoria.size(); i++){

%>

<p> Nombre: <%= productosCategoria.get(i).getNombre() %> </p><br>
<p> Precio: <%= productosCategoria.get(i).getPrecio() %> </p><br>
<p> Stock: <%= productosCategoria.get(i).getStock() %> </p><br>
<p> ------------------------------------------------------- </p>		
<%} %>

<a href='index.html'>Volver al índice.</a>


</body>
</html>