package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.*;


public interface ClienteDao {

	public List<Cliente> ObtenerListadoClientes(boolean estado);
	public boolean GuardarCliente(Cliente cli);
}
