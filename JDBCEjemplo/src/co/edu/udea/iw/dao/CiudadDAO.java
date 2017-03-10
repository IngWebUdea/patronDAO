package co.edu.udea.iw.dao;


import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * Interface que define los métodos permitidos para la Ciudades en el sistema 
 * 
 * @author Andrés Castro andres.castrop@udea.edu.co
 *
 */
public interface CiudadDAO {
	
	/**
	 * Obtiene la lista de ciudades en el sistema, ordenadas alfabéticamente por nombre.
	 * @return Lista de ciudades.
	 * @throws MyException Ocurre cuando hay probelas con la conexión a la DB.
	 */
	public List<Ciudad> get() throws MyException;
}
