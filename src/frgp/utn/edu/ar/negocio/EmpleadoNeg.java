package frgp.utn.edu.ar.negocio;

import frgp.utn.edu.ar.entidades.Empleado;
import frgp.utn.edu.ar.entidades.Usuario;

public interface EmpleadoNeg {
	Empleado ObtenerEmpleadoXUserId(Usuario usuario);
}
