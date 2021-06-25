package frgp.utn.edu.ar.negocioImpl;

import frgp.utn.edu.ar.daoImpl.UserDaoImpl;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocio.UserNeg;

public class UserNegImpl implements UserNeg {

	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	@Override
	public boolean eliminarUsuarioxIdNroCliente(int nroCliente) {
		
		ClienteNegImpl cliNegImpl = new ClienteNegImpl();
		Cliente cli = cliNegImpl.ObtenerClientexNroCliente(nroCliente);
		
		boolean resultado =  userDaoImpl.eliminarUsuarioxName(cli.getUsuario());
		
		return resultado;
	}

	@Override
	public Usuario obtenerUsuarioClientexNroCliente(int nroCliente) {
		
		ClienteNegImpl cliNegImpl = new ClienteNegImpl();
		Cliente cli = cliNegImpl.ObtenerClientexNroCliente(nroCliente);
		
		return cli.getUsuario();
	}
	


}
