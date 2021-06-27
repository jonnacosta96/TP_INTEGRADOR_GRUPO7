package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TransaccionesxCuentas")
public class Transaccion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IdTransaccion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTransaccion;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="NroCuenta")
	private Cuenta cuentaAsoc;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@OneToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="IdTipoTransaccion")
	private TipoTransaccion tipoTransaccion;
	
	@Column(name="Saldo",nullable=false)
	private float saldo;
	
	@Column(name="Fecha",nullable=false)
	private LocalDate fechaTransaccion;
	
	@Column(name="EstadoLinea")
	private boolean estadoTransaccion;
	
	//CONSTRUCTORES
	public Transaccion() {
		
	}
	
	public Transaccion(Cuenta cuentaAsoc, String descripcion, TipoTransaccion tipoTransaccion,
			float saldo, LocalDate fechaTransaccion, boolean estadoTransaccion) {
		
		this.cuentaAsoc = cuentaAsoc;
		this.descripcion = descripcion;
		this.tipoTransaccion = tipoTransaccion;
		this.saldo = saldo;
		this.fechaTransaccion = fechaTransaccion;
		this.estadoTransaccion = estadoTransaccion;
	}
	
	public Transaccion(int idTransaccion, Cuenta cuentaAsoc, String descripcion, TipoTransaccion tipoTransaccion,
			float saldo, LocalDate fechaTransaccion, boolean estadoTransaccion) {
		
		this.idTransaccion = idTransaccion;
		this.cuentaAsoc = cuentaAsoc;
		this.descripcion = descripcion;
		this.tipoTransaccion = tipoTransaccion;
		this.saldo = saldo;
		this.fechaTransaccion = fechaTransaccion;
		this.estadoTransaccion = estadoTransaccion;
	}


	//GETTERS AND SETTERS
	public int getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public Cuenta getCuentaAsoc() {
		return cuentaAsoc;
	}

	public void setCuentaAsoc(Cuenta cuentaAsoc) {
		this.cuentaAsoc = cuentaAsoc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoTransaccion getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public boolean isEstadoTransaccion() {
		return estadoTransaccion;
	}

	public void setEstadoTransaccion(boolean estadoTransaccion) {
		this.estadoTransaccion = estadoTransaccion;
	}

	@Override
	public String toString() {
		return "idTransaccion=" + idTransaccion + ", cuentaAsoc=" + cuentaAsoc + ", descripcion="
				+ descripcion + ", tipoTransaccion=" + tipoTransaccion + ", saldo=" + saldo + ", fechaTransaccion="
				+ fechaTransaccion + ", estadoTransaccion=" + estadoTransaccion;
	}
	
	
}
