package co.edu.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de la interface {@link CiudadDAO}
 * 
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public class CiudadDAOImpl extends DataSource implements CiudadDAO {

	@Override
	public List<Ciudad> get() throws MyException {
		
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		Connection cnx = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cnx = getConnection();
			ps = cnx.prepareStatement("SELECT * FROM ciudades ORDER BY Nombre");
			rs = ps.executeQuery();
			
			while(rs.next()){
				Ciudad ciudad = new Ciudad();
				
				ciudad.setCodigo(rs.getLong("Codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
				
				ciudades.add(ciudad);			
				
			}
			
		} catch (SQLException e) {
			throw new MyException("Ocurrió un error al obtener la informacón de las ciudades en la DB");
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			}catch(SQLException e){
				throw new MyException("Ocurrió un error al cerrar las conexiones a la DB", e);
			}
		}	
		
		return ciudades;
	}

	
}
