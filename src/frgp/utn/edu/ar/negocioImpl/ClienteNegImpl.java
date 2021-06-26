package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import javax.servlet.ServletConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import frgp.utn.edu.ar.daoImpl.ClienteDaoImpl;
import frgp.utn.edu.ar.daoImpl.ParametroDaoImpl;
import frgp.utn.edu.ar.daoImpl.ProvinciaDaoImpl;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.negocio.ClienteNeg;

public class ClienteNegImpl implements ClienteNeg {
		
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private ClienteDaoImpl cliDaoImpl;
	
	public void init(ServletConfig config) {
		ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		 this.cliDaoImpl = (ClienteDaoImpl)appContext.getBean("clienteDaoImpl");
	}
	
	@Override
	public List<Cliente> ObtenerListadoClientes(boolean estado) {
		if(cliDaoImpl == null)
			cliDaoImpl = (ClienteDaoImpl)appContext.getBean("clienteDaoImpl");
		List<Cliente> lista  = cliDaoImpl.ObtenerListadoClientes(estado);
		
		return lista;
	}

	@Override
	public boolean GuardarCliente(Cliente cli) {
		
		if(cliDaoImpl == null)
			cliDaoImpl = (ClienteDaoImpl)appContext.getBean("clienteDaoImpl");
		
		boolean Resultado = cliDaoImpl.GuardarCliente(cli);
		
		return Resultado;
	}

	@Override
	public Cliente ObtenerClientexNroCliente(int nroCliente) {
		
		if(cliDaoImpl == null)
			cliDaoImpl = (ClienteDaoImpl)appContext.getBean("clienteDaoImpl");
		
		Cliente cli = cliDaoImpl.ObtenerClientexNroCliente(nroCliente);
		
		return cli;
	}

	@Override
	public Cliente ObtenerClientexDNI(int dni) {
		
		if(cliDaoImpl == null)
			cliDaoImpl = (ClienteDaoImpl)appContext.getBean("clienteDaoImpl");
		
		Cliente cli = cliDaoImpl.ObtenerClientexDNI(dni);
		
		return cli;
	}

}
