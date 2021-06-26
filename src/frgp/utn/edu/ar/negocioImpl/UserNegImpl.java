package frgp.utn.edu.ar.negocioImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.daoImpl.UserDaoImpl;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocio.UserNeg;

public class UserNegImpl implements UserNeg {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private UserDaoImpl userDaoImpl = (UserDaoImpl)appContext.getBean("userDaoImpl");
	
	@Override
	public boolean eliminarUsuarioxIdNroCliente(int nroCliente) {
		
		ClienteNegImpl cliNegImpl = (ClienteNegImpl)appContext.getBean("clienteNegImpl");
		
		Cliente cli = cliNegImpl.ObtenerClientexNroCliente(nroCliente);
		
		boolean resultado =  userDaoImpl.eliminarUsuarioxName(cli.getUsuario());
		
		return resultado;
	}

	@Override
	public Usuario obtenerUsuarioClientexNroCliente(int nroCliente) {
		
		ClienteNegImpl cliNegImpl = (ClienteNegImpl)appContext.getBean("clienteNegImpl");
		
		Cliente cli = cliNegImpl.ObtenerClientexNroCliente(nroCliente);
		
		return cli.getUsuario();
	}
	


}
