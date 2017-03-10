package co.edu.udea.iw.dto;

/**
 * Clase DTO para gestionar los datos de la tabla Ciudad
 * @author Andrés Castro andres.castrop@udea.edu.co
 * 
 */
public class Ciudad {

	private long codigo;			//Código de la ciudad en la DB
	private String nombre;			//Nombre de la ciudad en lal DB
	private String codigoArea;		//Código de área dela ciudad en la DBS
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}

}
