package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidades.Cliente;

public interface ClienteNeg {
	
	public List<Cliente> ObtenerListadoClientes(boolean estado);
	public boolean GuardarCliente(Cliente cli);
}
