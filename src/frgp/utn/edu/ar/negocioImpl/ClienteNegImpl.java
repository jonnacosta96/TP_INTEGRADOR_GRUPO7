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

}
