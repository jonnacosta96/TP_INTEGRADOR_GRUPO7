package frgp.utn.edu.ar.dao;

import frgp.utn.edu.ar.entidades.Empleado;
import frgp.utn.edu.ar.entidades.Usuario;

public interface EmpleadoDao {
	
	Empleado ObtenerEmpleadoXUserId(Usuario usuario);
	
}
