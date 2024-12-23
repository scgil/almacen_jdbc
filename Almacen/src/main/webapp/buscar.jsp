<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curso.modelo.Producto.Categoria" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar producto</title>
</head>
<body>
<h1>Buscar producto por categoria</h1>

<%
Categoria[] categorias = Categoria.values();
%>

<form action="BuscarServlet" method="get">
	 <select name="categoria">
	 <% for (Categoria categoria : categorias){	 %> 
	  	<option value="<%= categoria.name() %>"><%= categoria.name() %></option>
	<% }%> 
	 </select>
	 <input type="submit" value="Enviar">
</form>
<a href='index.html'>Volver al índice.</a>
</body>
</html>