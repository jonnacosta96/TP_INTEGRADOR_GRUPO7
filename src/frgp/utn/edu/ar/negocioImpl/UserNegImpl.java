package frgp.utn.edu.ar.negocioImpl;

import javax.servlet.ServletConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import frgp.utn.edu.ar.daoImpl.UserDaoImpl;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocio.UserNeg;

public class UserNegImpl implements UserNeg {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
	private UserDaoImpl userDaoImpl;
	private ClienteNegImpl clienteNegImpl;

	public void init(ServletConfig config) {
	    ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
	    this.userDaoImpl = (UserDaoImpl)appContext.getBean("userDaoImpl");
	    this.clienteNegImpl = (ClienteNegImpl)appContext.getBean("clienteNegImpl");
	}
	
	@Override
	public boolean eliminarUsuarioxIdNroCliente(int nroCliente) {
		
		if(clienteNegImpl == null)
			clienteNegImpl = (ClienteNegImpl)appContext.getBean("clienteNegImpl");
		
		if(userDaoImpl == null)
			userDaoImpl = (UserDaoImpl)appContext.getBean("userDaoImpl");
		
		Cliente cli = clienteNegImpl.ObtenerClientexNroCliente(nroCliente);
		
		boolean resultado =  userDaoImpl.eliminarUsuarioxName(cli.getUsuario());
		
		return resultado;
	}

	@Override
	public Usuario obtenerUsuarioClientexNroCliente(int nroCliente) {
		
		if(clienteNegImpl == null)
			clienteNegImpl = (ClienteNegImpl)appContext.getBean("clienteNegImpl");
		
		Cliente cli = clienteNegImpl.ObtenerClientexNroCliente(nroCliente);
		
		return cli.getUsuario();
	}

	@Override
	public Usuario validateUser(Login login) {
		if(userDaoImpl == null)
			userDaoImpl = (UserDaoImpl)appContext.getBean("userDaoImpl");
		
		Usuario usuario = userDaoImpl.validateUser(login);
		
		return usuario;
	}
	


}
