package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoTransacciones")
public class TipoTransaccion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdTipoTransaccion")
	private int idTipoTransaccion;
	
	@Column(name="Descripcion",nullable=false)
	private String descripcion;
	
	@Column(name="EstadoLinea", columnDefinition="Boolean default true")
	private boolean estadoTipoTransaccion;
	
	public TipoTransaccion() {
		
	}

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
