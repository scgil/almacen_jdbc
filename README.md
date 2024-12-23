# Tercera prueba: Almacén de productos con JDBC, Datasource, DAO

## 1. Clase Producto

Representa un Producto

### 1.1. Descripción

La clase Producto permite instanciar productos y estos contienen la información sobre el identificador, nombre, categoría, precio y stock.

### 1.2. Funcionalidades

La clase Producto tiene las siguientes funcionalidades:

Constructor: Crea una instancia de Producto con el nombre, categoría, precio y stock.

### 1.3. Uso

Uso de la clase Producto

Para utilizar la clase Producto, primero debe instanciar un objeto pasando los argumentos adecuados al constructor.

Ejemplo: Producto producto = new Producto("Nevera", "Electrodomesticos", 500.50, 5);

## 2. Clase ProductoDAO

Representa el DAO para la clase Producto

### 2.1 Descripción

Esta clase proporciona métodos para realizar operaciones CRUD en la base de datos sobre los productos del Almacén.

### 2.2. Funcionalidades

La clase ProductoDAO tiene las siguientes funcionalidades:

save(Producto producto): inserta un producto.

update(Producto producto): actualiza un producto.

productos(): devuelve la lista de productos.

insertarProducto(Producto producto): inserta un producto en la lista de productos.

eliminarProducto(int indice): elimina un producto por su índice en la lista de productos.

modificar(int indice, String nombre, String categoria, double precio, int stock): modifica un producto por su índice en la lista de productos.

2.3. Uso

Uso de la clase ProductoService

Para utilizar la clase ProductoService, primero debe instanciar un objeto sin parámetros.

Ejemplo: ProductoService ps = new ProductoService();

3. Clase FrontController

Representa un FrontController, que es el controlador de la aplicación.

3.1 Descripción

Representa el Servlet que hace de Controller en la aplicación.

3.2. Funcionalidades

La clase FrontController tiene las siguientes funcionalidades:
doGet(HttpServletRequest request, HttpServletResponse response): captura la opción escogida como parámetro en index.html y distribuye al servlet o fichero .jsp adecuado.

4. Clase ListarServlet

Representa un Servlet para listar Productos.

4.1 Descripción

Se encarga de aportar la funcionalidad para listar los productos del Almacén.

4.2. Funcionalidades

La clase ListarServlet tiene las siguientes funcionalidades:
doGet(HttpServletRequest request, HttpServletResponse response): establece el atributo del request con el listado de productos y despacha hacia 'listar.jsp'.

5. Clase InsertarServlet

Representa un Servlet para insertar Productos.

5.1 Descripción

Se encarga de aportar la funcionalidad para insertar los productos del Almacén.

5.2. Funcionalidades

La clase InsertarServlet tiene las siguientes funcionalidades:
doPost(HttpServletRequest request, HttpServletResponse response): captura los parámetros de la request de 'insertar.jsp' e inserta el producto en la lista de productos de ProductoService. Se indica si hubo éxito o error en la operación.

6. Clase BuscarServlet

Representa un Servlet para buscar Productos.

6.1 Descripción

Se encarga de aportar la funcionalidad de buscar productos por categoría en el Almacén.

6.2. Funcionalidades

La clase InsertarServlet tiene las siguientes funcionalidades:
doPost(HttpServletRequest request, HttpServletResponse response): captura el parámetro de la request de 'buscar.jsp' con la categoría a buscar, establece en la request un atributo con el listado de productos por categoría  y despacha hacia 'buscarResultado.jsp', que mostrará los resultados de la búsqueda.

6. Clase EliminarServlet

Representa un Servlet para eliminar Productos.

6.1 Descripción

Se encarga de aportar la funcionalidad de eliminar un producto del Almacén.

6.2. Funcionalidades

La clase InsertarServlet tiene las siguientes funcionalidades:
doGet(HttpServletRequest request, HttpServletResponse response): captura el parámetro 'indexEliminar' de la request de 'eliminar.jsp', que es el índice del producto en la lista de productos de ProductoService y elimina el producto de la lista. Se informa del éxito o error en la operación.

7. Clase ModificarServlet

Representa un Servlet para modificar Productos.

7.1 Descripción

Se encarga de aportar la funcionalidad de seleccionar el producto a modificar.

7.2. Funcionalidades

La clase InsertarServlet tiene las siguientes funcionalidades:
doGet(HttpServletRequest request, HttpServletResponse response): captura el parámetro 'indexModificar' de la request en 'modificar.jsp', que es el índice del producto en la lista de productos de ProductoService y despacha hacia 'modificarProducto.jsp', que contiene el formulario para modificar el producto. Si hay algun error se informa.

8. Clase ModificarProductoServlet

Representa un Servlet para modificar un producto ya seleccionado.

8.1 Descripción

Se encarga de aportar la funcionalidad de modificar el producto seleccionado.

8.2. Funcionalidades

La clase InsertarServlet tiene las siguientes funcionalidades:

doPost(HttpServletRequest request, HttpServletResponse response): captura de la request los parámetros del formulario de 'modificarProducto.jsp' junto con el 'indiceModificar' (que es un input hidden) y modifica el producto de la lista de productos de ProductoService. Se informa del éxito o error de la operación.

9. Contribuir

Fork it!

Crea tu feature branch: git checkout -b my-new-feature

Haz Commit de tus cambios: git commit -am 'Add some feature'

Push al branch: git push origin my-new-feature

Submit un pull request
      
10. Historia

•	Version 1.1 (2024-12-17) - lanzamiento inicial

11. Créditos y atribuciones

Developer – Sergio Castro

12. License

The MIT License (MIT)
Copyright (c) 2015
