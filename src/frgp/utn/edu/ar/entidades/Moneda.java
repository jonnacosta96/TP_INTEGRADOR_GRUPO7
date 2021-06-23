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
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="EstadoLinea")
	private Boolean estadoLinea;
	
	public Moneda() {
		super();
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
	
	public Boolean getEstadoLinea() {
		return estadoLinea;
	}

	public void setEstadoLinea(Boolean estadoLinea) {
		this.estadoLinea = estadoLinea;
	}

	public Moneda(String codigo, String nombre, Boolean estadoLinea) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.estadoLinea =  estadoLinea;
	}
}
