package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import javax.servlet.ServletConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import frgp.utn.edu.ar.entidades.TipoCuenta;
import frgp.utn.edu.ar.negocio.TipoCuentaNeg;
import frgp.utn.edu.ar.daoImpl.TipoCuentaDaoImpl;
import frgp.utn.edu.ar.daoImpl.UserDaoImpl;

public class TipoCuentaNegImpl implements TipoCuentaNeg {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private TipoCuentaDaoImpl tipoCuentaDaoImpl;

	public void init(ServletConfig config) {
	    ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
	        this.tipoCuentaDaoImpl = (TipoCuentaDaoImpl)appContext.getBean("tipoCuentaDaoImpl");
	}

	@Override
	public List<TipoCuenta> ObtenerListadoTiposCuenta(boolean estado) {
		if(tipoCuentaDaoImpl == null)
			tipoCuentaDaoImpl = (TipoCuentaDaoImpl)appContext.getBean("tipoCuentaDaoImpl");
		List<TipoCuenta> lista = tipoCuentaDaoImpl.ObtenerListadoTiposCuenta(estado);
		return lista;
	}

	@Override
	public TipoCuenta ObtenerTipoCuenta(String codigo) {
		if(tipoCuentaDaoImpl == null)
			tipoCuentaDaoImpl = (TipoCuentaDaoImpl)appContext.getBean("tipoCuentaDaoImpl");
		TipoCuenta tipoCuenta = tipoCuentaDaoImpl.ObtenerTipoCuenta(codigo);
		return tipoCuenta;
	}

}
