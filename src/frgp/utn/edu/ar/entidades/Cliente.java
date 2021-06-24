package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="NroCliente")
	private int nroCliente;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Apellido")
	private String apellido;
	
	@Column(name="Dni",nullable=false,unique=true)
	private int dni;
	
	@Column(name="Sexo",nullable=false)
	private String sexo;
	
	@OneToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="IdPais")
	private Pais pais;
	
	@Column(name="FechaNacimiento",nullable=false)
	private LocalDate fechaNacimiento;
	
	@Column(name="Direccion",nullable=true)
	private String direccion;
	
	@OneToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="IdProvincia")
	private Provincia prov;

	@OneToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="IdLocalidad")
	private Localidad loc;
	
	@OneToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="UserName")
	private Usuario usuario;
	
	@Column(name="EstadoLinea", columnDefinition="Boolean default true")
	private boolean estadoCliente;
	
	//CONSTRUCTORES
	public Cliente() {
		
	}

	public Cliente(int nroCliente, int dni, String sexo, Pais pais, LocalDate fechaNacimiento, String direccion,
			Provincia prov, Localidad loc, Usuario usuario, boolean estadoCliente, String nombre, String apellido) {

		this.nroCliente = nroCliente;
		this.dni = dni;
		this.sexo = sexo;
		this.pais = pais;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.prov = prov;
		this.loc = loc;
		this.usuario = usuario;
		this.estadoCliente = estadoCliente;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	//GETTERS AND SETTERS

	@Override
	public String toString() {
		return "nroCliente=" + nroCliente + ", dni=" + dni + ", sexo=" + sexo + ", pais=" + pais
				+ ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", prov=" + prov + ", loc="
				+ loc + ", usuario=" + usuario + ", estadoCliente=" + estadoCliente;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Provincia getProv() {
		return prov;
	}

	public void setProv(Provincia prov) {
		this.prov = prov;
	}

	public Localidad getLoc() {
		return loc;
	}

	public void setLoc(Localidad loc) {
		this.loc = loc;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(boolean estadoCliente) {
		this.estadoCliente = estadoCliente;
	}




	
	
}
