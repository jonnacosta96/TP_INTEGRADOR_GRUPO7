package helpers;

import frgp.utn.edu.ar.entidades.Parametro;
import frgp.utn.edu.ar.negocioImpl.ParametroNegImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CBUHelper {

	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
	public static Integer getNewCbu()
	{
		ParametroNegImpl parametroNegImpl = (ParametroNegImpl)appContext.getBean("parametroNegImpl");
		
		Parametro parametro = parametroNegImpl.ObtenerParametroxCodigo("LAST_CBU");
    	Integer cbu = parametro.getIntegerParamValue() + 1;
    	parametro.setIntegerParamValue(cbu);
    	
    	parametroNegImpl.GuardarParametro(parametro);
    	
    	return cbu;
	}
	
}
