package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import frgp.utn.edu.ar.entidades.Cliente;
import helpers.CBUHelper;

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
    private Integer CBU;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FechaCreacion")
    private Date fechaCreacion;
	
	@Column(name ="Saldo", precision=10, scale=2)
    private float saldo;
	
	@Column(name="Activo")
    private Boolean activo;
	
	public Cuenta() {
		
	}
	
	public Cuenta(Cliente cliente, String nombre, TipoCuenta tipoCuenta, Integer cbu,
			Date fechaCreacion, float saldo, Boolean activo) {
		this.cliente = cliente;
		this.nombre = nombre;
		this.tipoCuenta = tipoCuenta;
		this.CBU = cbu;
		this.fechaCreacion = fechaCreacion;
		this.saldo = saldo;
		this.activo = activo;
	}

	public Cuenta(int nroCuenta, Cliente cliente, String nombre, TipoCuenta tipoCuenta,
			Date fechaCreacion, float saldo, Boolean activo) {
		this.nroCuenta = nroCuenta;
		this.cliente = cliente;
		this.nombre = nombre;
		this.tipoCuenta = tipoCuenta;
		this.fechaCreacion = fechaCreacion;
		this.saldo = saldo;
		this.activo = activo;
	}
	
	

	public Cuenta(float saldo, Boolean activo) {
		super();
		this.saldo = saldo;
		this.activo = activo;
	}

	public int getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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

	public Integer getCBU() {
		return CBU;
	}

	public void setCBU(Integer cBU) {
		CBU = cBU;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
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

	@Override
	public String toString() {
		return "nroCuenta=" + nroCuenta + ", cliente=" + cliente + ", nombre=" + nombre + ", tipoCuenta="
				+ tipoCuenta + ", CBU=" + CBU + ", fechaCreacion=" + fechaCreacion + ", saldo=" + saldo + ", activo="
				+ activo;
	}

	public void initCuenta()
	{
		this.fechaCreacion = Calendar.getInstance().getTime();
		this.CBU = CBUHelper.getNewCbu();
	}

}
