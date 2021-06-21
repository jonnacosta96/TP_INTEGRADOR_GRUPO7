package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import java.time.LocalDate;

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
import frgp.utn.edu.ar.entidades.Cliente;

@Entity
@Table(name="Cuentas")
public class Cuenta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="NroCuenta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nroCuenta;
	
	@OneToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="NroCliente")
    private Cliente cliente;
	
	@Column(name="Nombre")
    private String nombre;
	
	@OneToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="CodigoTipoCuenta")
	private TipoCuenta tipoCuenta;
	
	@Column(name="Cbu")
    private String CBU;
	
	@Column(name="FechaCreacion")
    private LocalDate fechaCreacion;
	
	@Column(name="Saldo")
    private float saldo;
	
	@Column(name="Activo")
    private Boolean activo;
	
	public Cuenta() {
		super();
	}

	public Cuenta(int nroCuenta, Cliente cliente, String nombre, TipoCuenta tipoCuenta, String cBU,
			LocalDate fechaCreacion, float saldo, Boolean activo) {
		super();
		this.nroCuenta = nroCuenta;
		this.cliente = cliente;
		this.nombre = nombre;
		this.tipoCuenta = tipoCuenta;
		CBU = cBU;
		this.fechaCreacion = fechaCreacion;
		this.saldo = saldo;
		this.activo = activo;
	}

	public int getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public Cliente getNroCliente() {
		return cliente;
	}

	public void setNroCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getCBU() {
		return CBU;
	}

	public void setCBU(String cBU) {
		CBU = cBU;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
