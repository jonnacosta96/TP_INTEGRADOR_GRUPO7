package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import javax.servlet.ServletConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import frgp.utn.edu.ar.daoImpl.PaisDaoImpl;
import frgp.utn.edu.ar.daoImpl.ParametroDaoImpl;
import frgp.utn.edu.ar.entidades.Pais;
import frgp.utn.edu.ar.negocio.PaisNeg;

public class PaisNegImpl implements PaisNeg{
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private PaisDaoImpl paisDaoImpl;

	public void init(ServletConfig config) {
	    ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
	        this.paisDaoImpl = (PaisDaoImpl)appContext.getBean("paisDaoImpl");
	}
	
	@Override
	public List<Pais> obtenerListadoPaises(boolean estado) {
		
		if(paisDaoImpl == null)
			paisDaoImpl = (PaisDaoImpl)appContext.getBean("paisDaoImpl");
		
		List<Pais> lista = paisDaoImpl.obtenerListadoPaises(estado);
		
		return lista;
	}
	
	

}
