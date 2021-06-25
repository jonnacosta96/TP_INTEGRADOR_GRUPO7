package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoTransacciones")
public class TipoTransaccion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdTipoTransaccion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoTransaccion;
	
	@Column(name="Descripcion",nullable=false)
	private String descripcion;
	
	@Column(name="EstadoLinea", columnDefinition="Boolean default true")
	private boolean estadoTipoTransaccion;
	
	
	//CONSTRUCTORES
	public TipoTransaccion() {
		
	}
	
	public TipoTransaccion(String descripcion, boolean estadoTipoTransaccion) {
		this.descripcion = descripcion;
		this.estadoTipoTransaccion = estadoTipoTransaccion;
	}

	public TipoTransaccion(int idTipoTransaccion, String descripcion, boolean estadoTipoTransaccion) {
		this.idTipoTransaccion = idTipoTransaccion;
		this.descripcion = descripcion;
		this.estadoTipoTransaccion = estadoTipoTransaccion;
	}
	
	//GETTERS AND SETTERS
	public int getIdTipoTransaccion() {
		return idTipoTransaccion;
	}

	public void setIdTipoTransaccion(int idTipoTransaccion) {
		this.idTipoTransaccion = idTipoTransaccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstadoTipoTransaccion() {
		return estadoTipoTransaccion;
	}

	public void setEstadoTipoTransaccion(boolean estadoTipoTransaccion) {
		this.estadoTipoTransaccion = estadoTipoTransaccion;
	}

	@Override
	public String toString() {
		return "idTipoTransaccion=" + idTipoTransaccion + ", descripcion=" + descripcion
				+ ", estadoTipoTransaccion=" + estadoTipoTransaccion;
	}
	
	
}
