package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Monedas")
public class Moneda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Codigo")
	private String codigo;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="EstadoLinea", columnDefinition="Boolean default true")
	private boolean estadoMoneda;
	
	public Moneda() {

	}
	
	public Moneda(String codigo, String nombre, boolean estadoMoneda) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.estadoMoneda = estadoMoneda;
	}


	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean getEstadoMoneda() {
		return estadoMoneda;
	}
	public void setEstadoMoneda(boolean estadoMoneda) {
		this.estadoMoneda = estadoMoneda;
	}

	@Override
	public String toString() {
		return "codigo=" + codigo + ", nombre=" + nombre + ", estadoMoneda=" + estadoMoneda;
	}
	
	
}
