# Tercera prueba: Almacén de productos con JDBC, Datasource, DAO

## 1. Clase ConexionBD

Representa una conexión a Base de Datos

### 1.1. Descripción

La clase ConexionBD devuelve una conexión a BD gestionada con DataSource.

### 1.2. Funcionalidades

La clase ConexionBD tiene las siguientes funcionalidades:

public Connection conexion(): devuelve una conexión a BD con DataSource.

### 1.3. Uso

Uso de la clase ConexionBD

Para utilizar la clase ConexionBD, primero se debe instanciar un objeto.

Ejemplo: ConexionBD cbd = new ConexionBD();
	Connection conex = cbd.conexion();

## 2. Clase Producto

Representa un Producto

### 2.1. Descripción

La clase Producto permite instanciar productos y estos contienen la información sobre el identificador, nombre, categoría, precio y stock.

### 2.2. Funcionalidades

La clase Producto tiene las siguientes funcionalidades:

Constructor_1: Crea una instancia de Producto con el nombre, categoría, precio y stock.

Constructor_2: Crea una instancia de Producto con el id, nombre, categoría, precio y stock.

Getters, setters, hashCode y equals.

### 2.3. Uso

Uso de la clase Producto

Para utilizar la clase Producto, primero debe instanciar un objeto pasando los argumentos adecuados al constructor.

Ejemplo: Producto producto = new Producto("Nevera", "Electrodomesticos", 500.50, 5);

## 3. Clase ProductoDAO

Representa el DAO para la clase Producto e implementa la interfaz IProducto.

### 3.1 Descripción

Esta clase implementa métodos para realizar operaciones CRUD en la base de datos sobre los productos del Almacén.

### 3.2. Funcionalidades

La clase ProductoDAO tiene las siguientes funcionalidades:

save(Producto producto): inserta un producto.

update(Producto producto): actualiza un producto.

remove(Producto producto): elimina un producto.

findBy(int id): devuelve un producto por su identificador.

findAll(): devuelve una lista de productos.

findByCategoria(String categoria): devuelve una lista de productos filtrados por categoría.

### 3.3. Uso

Uso de la clase ProductoDAO

Para utilizar la clase ProductoDAO, primero debe instanciar un objeto sin parámetros para acceder a sus metodos.

Ejemplo: ProductoDAO ps = new ProductoDAO();

## 4. Clase FrontController

Representa un FrontController, que es el controlador de la aplicación.

### 4.1 Descripción

Representa el Servlet que hace de Controller en la aplicación.

### 4.2. Funcionalidades

La clase FrontController tiene las siguientes funcionalidades:
doGet(HttpServletRequest request, HttpServletResponse response): captura la opción escogida como parámetro en index.html y distribuye al servlet o fichero .jsp adecuado.

## 5. Clase ListarServlet

Representa un Servlet para listar Productos.

### 5.1 Descripción

Se encarga de aportar la funcionalidad para listar los productos del Almacén.

### 5.2. Funcionalidades

La clase ListarServlet tiene las siguientes funcionalidades:
doGet(HttpServletRequest request, HttpServletResponse response): establece el atributo del request con el listado de productos obtenidos de la BD con ProductoDAO y despacha hacia 'listar.jsp'.

## 6. Clase InsertarServlet

Representa un Servlet para insertar Productos.

### 6.1 Descripción

Se encarga de aportar la funcionalidad para insertar los productos del Almacén.

### 6.2. Funcionalidades

La clase InsertarServlet tiene las siguientes funcionalidades:
doPost(HttpServletRequest request, HttpServletResponse response): captura los parámetros de la request de 'insertar.jsp' e inserta el producto en Base de Datos usando ProductoDAO. Se indica si hubo éxito o error en la operación.

## 7. Clase BuscarServlet

Representa un Servlet para buscar Productos.

### 7.1 Descripción

Se encarga de aportar la funcionalidad de buscar productos por categoría en el Almacén.

### 7.2. Funcionalidades

La clase BuscarServlet tiene las siguientes funcionalidades:
doGet(HttpServletRequest request, HttpServletResponse response): captura el parámetro de la request de 'buscar.jsp' con la categoría a buscar, establece en la request un atributo con el listado de productos por categoría, que se obtiene usando ProductoDAO, y despacha hacia 'buscarResultado.jsp', que mostrará los resultados de la búsqueda.

## 8. Clase EliminarServlet

Representa un Servlet para eliminar Productos.

### 8.1 Descripción

Se encarga de aportar la funcionalidad de eliminar un producto del Almacén.

### 8.2. Funcionalidades

La clase EliminarServlet tiene las siguientes funcionalidades:

doGet(HttpServletRequest request, HttpServletResponse response): captura el parámetro 'indexEliminar' de la request de 'eliminar.jsp', que es el id del producto en la Base de Datos , y elimina el producto de la BD usando ProductoDAO. Se informa del éxito o error en la operación.

## 9. Clase ModificarServlet

Representa un Servlet para modificar Productos.

### 9.1 Descripción

Se encarga de aportar la funcionalidad de seleccionar el producto a modificar.

### 9.2. Funcionalidades

La clase ModificarServlet tiene las siguientes funcionalidades:
doGet(HttpServletRequest request, HttpServletResponse response): captura el parámetro 'indexModificar' de la request en 'modificar.jsp', que es el id del producto en Base de Datos y despacha hacia 'modificarProducto.jsp', que contiene el formulario para modificar el producto. Si hay algun error se informa.

## 10. Clase ModificarProductoServlet

Representa un Servlet para modificar un producto ya seleccionado.

### 10.1 Descripción

Se encarga de aportar la funcionalidad de modificar el producto seleccionado.

### 10.2. Funcionalidades

La clase ModificarProductoServlet tiene las siguientes funcionalidades:

doPost(HttpServletRequest request, HttpServletResponse response): captura de la request los parámetros del formulario de 'modificarProducto.jsp' junto con el 'indiceModificar' (que es un input hidden) y modifica el producto en Base de Datos usando ProductoDAO. Se informa del éxito o error de la operación.

## 11. Contribuir

Fork it!

Crea tu feature branch: git checkout -b my-new-feature

Haz Commit de tus cambios: git commit -am 'Add some feature'

Push al branch: git push origin my-new-feature

Submit un pull request
      
## 12. Historia

Version 1.1 (2024-12-17) - lanzamiento inicial

## 13. Créditos y atribuciones

Developer – Sergio Castro

## 14. License

The MIT License (MIT)
Copyright (c) 2015
