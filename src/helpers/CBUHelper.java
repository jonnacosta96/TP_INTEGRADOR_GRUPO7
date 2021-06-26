package helpers;

import frgp.utn.edu.ar.daoImpl.ClienteDaoImpl;
import frgp.utn.edu.ar.entidades.Parametro;
import frgp.utn.edu.ar.negocioImpl.ParametroNegImpl;

import javax.servlet.ServletConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CBUHelper {

	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private static ParametroNegImpl parametroNegImpl;
	
	public void init(ServletConfig config) {
	    ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
	        this.parametroNegImpl = (ParametroNegImpl)appContext.getBean("parametroDaoImpl");
	}
	
	public static Integer getNextCbu()
	{
		if(parametroNegImpl == null)
			parametroNegImpl = (ParametroNegImpl)appContext.getBean("parametroNegImpl");
		
		Parametro parametro = parametroNegImpl.ObtenerParametroxCodigo("LAST_CBU");
    	Integer cbu = parametro.getIntegerParamValue() + 1;
    	parametro.setIntegerParamValue(cbu);
    	
    	parametroNegImpl.GuardarParametro(parametro);
    	
    	return cbu;
	}
	
}
