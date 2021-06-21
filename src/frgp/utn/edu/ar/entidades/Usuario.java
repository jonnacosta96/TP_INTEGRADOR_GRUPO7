package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="UserName")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Apellido")
	private String apellido;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Tipo")
	private String tipo;
	
	@Column(name="Activo")
	private Boolean activo;

	public Usuario() {
		super();
	}

	public Usuario(String username, String password, String nombre, String apellido, String email, String tipo,
			Boolean activo) {
		super();
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.tipo = tipo;
		this.activo = activo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
