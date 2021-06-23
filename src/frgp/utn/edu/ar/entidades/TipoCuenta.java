package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TiposCuenta")
public class TipoCuenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Codigo")
	private String codigo;
	
	@OneToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="CodigoMoneda")
	private Moneda moneda;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="EstadoLinea", columnDefinition="Boolean default true")
	private boolean estadoTipoCuenta;
	
	public TipoCuenta() {

	}
	
	public TipoCuenta(String codigo, Moneda moneda, String nombre, boolean estadoTipoCuenta) {
		this.codigo = codigo;
		this.moneda = moneda;
		this.nombre = nombre;
		this.estadoTipoCuenta = estadoTipoCuenta;
	}

	public TipoCuenta(String codigo, Moneda moneda, String nombre) {
		this.codigo = codigo;
		this.moneda = moneda;
		this.nombre = nombre;
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
	public boolean isEstadoTipoCuenta() {
		return estadoTipoCuenta;
	}
	public void setEstadoTipoCuenta(boolean estadoTipoCuenta) {
		this.estadoTipoCuenta = estadoTipoCuenta;
	}
	
	@Override
	public String toString() {
		return "codigo=" + codigo + ", moneda=" + moneda + ", nombre=" + nombre;
	}
	
	
	
}
