package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import javax.servlet.ServletConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import frgp.utn.edu.ar.daoImpl.LocalidadDaoImpl;
import frgp.utn.edu.ar.entidades.Localidad;
import frgp.utn.edu.ar.negocio.LocalidadNeg;

public class LocalidadNegImpl implements LocalidadNeg{
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

	private LocalidadDaoImpl locDaoImpl;

	public void init(ServletConfig config) {
	    ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
	        this.locDaoImpl = (LocalidadDaoImpl)appContext.getBean("clienteDaoImpl");
	}
	
	@Override
	public List<Localidad> obtenerListadoLocalidades(boolean estado) {
		
		if(locDaoImpl == null)
			locDaoImpl = (LocalidadDaoImpl)appContext.getBean("localidadDaoImpl");
		
		List<Localidad> lista = locDaoImpl.obtenerListadoLocalidades(estado);
		
		return lista;
	}

}
