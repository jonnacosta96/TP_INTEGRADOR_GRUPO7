package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import javax.servlet.ServletConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import frgp.utn.edu.ar.daoImpl.ProvinciaDaoImpl;
import frgp.utn.edu.ar.entidades.Provincia;
import frgp.utn.edu.ar.negocio.ProvinciaNeg;

public class ProvinciaNegImpl implements ProvinciaNeg{
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

	private ProvinciaDaoImpl provDaoImpl;

	public void init(ServletConfig config) {
	    ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
	        this.provDaoImpl = (ProvinciaDaoImpl)appContext.getBean("provDaoImpl");
	}

	@Override
	public List<Provincia> obtenerListadoProvincias(boolean estado) {
		if(provDaoImpl == null)
			provDaoImpl = (ProvinciaDaoImpl)appContext.getBean("provinciaDaoImpl");
		List<Provincia> lista = provDaoImpl.obtenerListadoProvincias(estado);
		
		return lista;
	}
	
	

}
