package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import frgp.utn.edu.ar.daoImpl.ClienteDaoImpl;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.negocio.ClienteNeg;

public class ClienteNegImpl implements ClienteNeg {

	private ClienteDaoImpl cliDaoImpl = new ClienteDaoImpl();
	
	@Override
	public List<Cliente> ObtenerListadoClientes(boolean estado) {

		List<Cliente> lista  = cliDaoImpl.ObtenerListadoClientes(estado);
		
		return lista;
	}

	@Override
	public boolean GuardarCliente(Cliente cli) {
		
		boolean Resultado = cliDaoImpl.GuardarCliente(cli);
		
		return Resultado;
	}

	@Override
	public Cliente ObtenerClientexNroCliente(int nroCliente) {
		
		Cliente cli = cliDaoImpl.ObtenerClientexNroCliente(nroCliente);
		
		return cli;
	}

	@Override
	public Cliente ObtenerClientexDNI(int dni) {
		
		Cliente cli = cliDaoImpl.ObtenerClientexDNI(dni);
		
		return cli;
	}

}
