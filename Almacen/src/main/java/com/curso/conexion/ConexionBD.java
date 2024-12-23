package com.curso.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * La clase Conexion BD representa una conexión a base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/19
 */
public class ConexionBD {
	
	public Connection conexion() {
		Connection conex = null;
		DataSource ds;
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env"); //Esto es "fijo"
			ds = (DataSource) envContext.lookup("jdbc/AlmacenDataSource"); //nombre elegido para el Datasource
			
			try {
				conex = ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (NamingException e) {
			e.printStackTrace();
		}
		
		return conex;
		
	}

}
