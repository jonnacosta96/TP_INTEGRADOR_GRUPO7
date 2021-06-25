package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Provincias")
public class Provincia implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdProvincia")
	private int idProvincia;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="EstadoLinea", columnDefinition="Boolean default true")
	private boolean estadoProvincia;
	
	//CONSTRUCTORES
	public Provincia() {
		
	}
	
	public Provincia(int idProvincia, String nombre, boolean estadoProvincia) {
		this.idProvincia = idProvincia;
		this.nombre = nombre;
		this.estadoProvincia = estadoProvincia;
	}


	//GETTERS AND SETTERS
	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstadoProvincia() {
		return estadoProvincia;
	}

	public void setEstadoProvincia(boolean estadoProvincia) {
		this.estadoProvincia = estadoProvincia;
	}

	@Override 
	public String toString() {
		return nombre;
	}
	
	
}
