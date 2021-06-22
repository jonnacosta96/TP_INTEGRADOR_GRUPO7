package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Paises")
public class Pais implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IdPais")
	private int idPais;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="EstadoLinea")
	private boolean estadoPais;

	
	//CONSTRUCTORES
	public Pais() {
		
	}
	
	public Pais(int idPais, String nombre, boolean estadoPais) {
		this.idPais = idPais;
		this.nombre = nombre;
		this.estadoPais = estadoPais;
	}
	
	
	//GETTERS AND SETTERS
	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstadoPais() {
		return estadoPais;
	}

	public void setEstadoPais(boolean estadoPais) {
		this.estadoPais = estadoPais;
	}

	@Override
	public String toString() {
		return "idPais=" + idPais + ", nombre=" + nombre + ", estadoPais=" + estadoPais;
	}	
	
	

}
