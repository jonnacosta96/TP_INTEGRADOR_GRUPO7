package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="NroCliente")
	private int nroCliente;
	
	@Column(name="Nombre",nullable=false)
	private String nombre;
	
	@Column(name="Apellido",nullable=false)
	private String apellido;
	
	@Column(name="Dni",nullable=false,unique=true)
	private int dni;
	
	@Column(name="Sexo",nullable=false)
	private String sexo;
	
	@Column(name="IdPais",nullable=false)
	private int idPais;
	
	@Column(name="FechaNacimiento",nullable=false)
	private LocalDate fechaNacimiento;
	
	@Column(name="Direccion",nullable=true)
	private String direccion;
	
	@Column(name="IdProvincia",nullable=false)
	private int idProvincia;
	
	@Column(name="IdLocalidad",nullable=false)
	private int idLocalidad;
	
	@Column(name="EstadoLinea", columnDefinition="Boolean default true")
	private boolean estadoCliente;
	
	public Cliente() {
		
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

	@Override
	public String toString() {
		return "Cliente [nroCliente=" + nroCliente + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	

}
