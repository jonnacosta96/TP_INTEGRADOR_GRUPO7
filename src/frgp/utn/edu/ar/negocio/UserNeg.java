package frgp.utn.edu.ar.negocio;

import frgp.utn.edu.ar.entidades.Usuario;

public interface UserNeg {

	public boolean eliminarUsuarioxIdNroCliente(int nroCliente);
	public Usuario obtenerUsuarioClientexNroCliente(int nroCliente);
	
}
