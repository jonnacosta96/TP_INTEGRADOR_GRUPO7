package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TiposCuenta")
public class TipoCuenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Codigo")
	private String codigo;
	
	@ManyToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="CodigoMoneda")
	private Moneda moneda;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="EstadoLinea")
	private Boolean estadoLinea;
	
	public TipoCuenta() {

	}

	public TipoCuenta(String codigo, Moneda moneda, String nombre, Boolean estadoLinea) {
		super();
		this.codigo = codigo;
		this.moneda = moneda;
		this.nombre = nombre;
		this.estadoLinea = estadoLinea;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
