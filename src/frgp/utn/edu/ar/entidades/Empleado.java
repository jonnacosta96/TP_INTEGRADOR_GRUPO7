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
@Table(name="Empleados")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="NroEmpleado")
	private int nroEmpleado;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Apellido")
	private String apellido;
	
	@OneToOne(cascade= { CascadeType.ALL})
	@JoinColumn(name="UserName")
	private Usuario usuario;

	public Empleado() {
		
	}
	
	public Empleado(int nroEmpleado, String nombre, String apellido, Usuario usuario) {
		this.nroEmpleado = nroEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
	}

	public int getNroEmpleado() {
		return nroEmpleado;
	}

	public void setNroEmpleado(int nroEmpleado) {
		this.nroEmpleado = nroEmpleado;
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

}
