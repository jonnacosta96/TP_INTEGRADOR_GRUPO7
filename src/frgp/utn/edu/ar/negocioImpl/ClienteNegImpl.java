package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.daoImpl.ClienteDaoImpl;
import frgp.utn.edu.ar.daoImpl.ProvinciaDaoImpl;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.negocio.ClienteNeg;

public class ClienteNegImpl implements ClienteNeg {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private ClienteDaoImpl cliDaoImpl = (ClienteDaoImpl)appContext.getBean("clienteDaoImpl");
	
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
