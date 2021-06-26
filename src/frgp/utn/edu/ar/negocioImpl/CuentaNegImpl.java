package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import frgp.utn.edu.ar.daoImpl.ClienteDaoImpl;
import frgp.utn.edu.ar.daoImpl.CuentaDaoImpl;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.negocio.CuentaNeg;

public class CuentaNegImpl implements CuentaNeg {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private CuentaDaoImpl cuentaDaoImpl;
	
	public void init(ServletConfig config) {
		ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		 this.cuentaDaoImpl = (CuentaDaoImpl)appContext.getBean("cuentaDaoImpl");
	}
	
	public void setDataAccess(CuentaDaoImpl dataAccess) {
		this.cuentaDaoImpl = dataAccess;
	}


	@Override
	public List<Cuenta> ObtenerListadoCuentas(boolean estado) {
		if(cuentaDaoImpl == null)
			cuentaDaoImpl = (CuentaDaoImpl)appContext.getBean("cuentaDaoImpl");
		List<Cuenta> lista  = cuentaDaoImpl.ObtenerListadoCuentas(estado);
		
		return lista;
	}

	@Override
	public Cuenta ObtenerCuentaxNroCuenta(int nroCuenta) {
		if(cuentaDaoImpl == null)
			cuentaDaoImpl = (CuentaDaoImpl)appContext.getBean("cuentaDaoImpl");
		Cuenta cuenta = cuentaDaoImpl.ObtenerCuentaxNroCuenta(nroCuenta);
		
		return cuenta;
		
	}

	@Override
	public boolean GuardarCuenta(Cuenta cuenta) {
		if(cuentaDaoImpl == null)
			cuentaDaoImpl = (CuentaDaoImpl)appContext.getBean("cuentaDaoImpl");
		boolean Resultado = cuentaDaoImpl.GuardarCuenta(cuenta);
		
		return Resultado;
	}

	@Override
	public Long CantidadCuentasxNroCliente(Cliente cliente) {
		if(cuentaDaoImpl == null)
			cuentaDaoImpl = (CuentaDaoImpl)appContext.getBean("cuentaDaoImpl");
		Long cantidadCuentas = cuentaDaoImpl.CantidadCuentasxNroCliente(cliente);
		return cantidadCuentas;
	}

}
