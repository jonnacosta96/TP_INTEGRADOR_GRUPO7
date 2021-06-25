package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Localidades")
public class Localidad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IdLocalidad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLocalidad;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="EstadoLinea", columnDefinition="Boolean default true")
	private boolean estadoLocalidad;
	
	//CONSTRUCTORES
	public Localidad() {
		
	}
	
	public Localidad(String nombre, boolean estadoLocalidad) {
		this.nombre = nombre;
		this.estadoLocalidad = estadoLocalidad;
	}
	
	public Localidad(int idLocalidad, String nombre, boolean estadoLocalidad) {
		this.idLocalidad = idLocalidad;
		this.nombre = nombre;
		this.estadoLocalidad = estadoLocalidad;
	}

	//GETTERS AND SETTERS
	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstadoLocalidad() {
		return estadoLocalidad;
	}

	public void setEstadoLocalidad(boolean estadoLocalidad) {
		this.estadoLocalidad = estadoLocalidad;
	}

	@Override
	public String toString() {
		return "idLocalidad=" + idLocalidad + ", nombre=" + nombre + ", estadoLocalidad=" + estadoLocalidad;
	}
	
	
}
