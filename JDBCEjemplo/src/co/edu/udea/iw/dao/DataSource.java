package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.MyException;

/**
 * Encargada de realizar conexiones a la DB 
 * @author Andrés Castro andres.castrop@udea.edu.co
 *
 */
public class DataSource {

	/**
	 * Método encargado de hacer el manejo de la conexión a la DB
	 * @return
	 * @throws MyException
	 */
	public Connection getConnection() throws MyException {
		
		Connection cnx = null;
		String url = "jdbc:mysql://localhost:3306/clase";
		String user = "root";
		String pwd = "root";		
		
		try{
			/*
			 * Cargamos en el class loader de la aplicación el driver de conexion a nuestra base de datos.
			 */
			Class.forName("com.mysql.jdbc.Driver");
			
			/*
			 * Se establece la conexión a la DB solicitando tres parámetros:
			 * Url de conexión, usuario de la db, contraseña de usuario.
			 */
			cnx = DriverManager.getConnection(url, user, pwd);			
							
			
		} catch (ClassNotFoundException e) {
			
			throw new MyException("El driver de conexión a la base de datos no ha sido encontrado", e);
			
		} catch (SQLException e) {
			throw new MyException("Ha ocurrido un error estableciendo la conexón con la base de datos", e);
		}
		
		return cnx;
	}
}

