package frgp.utn.edu.ar.negocioImpl;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;

import frgp.utn.edu.ar.dao.ParametroDao;
import frgp.utn.edu.ar.daoImpl.ParametroDaoImpl;
import frgp.utn.edu.ar.daoImpl.ProvinciaDaoImpl;
import frgp.utn.edu.ar.entidades.Parametro;

public class ParametroNegImpl implements ParametroDao {

	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private ParametroDaoImpl parametroDaoImpl;
	
	public void init(ServletConfig config) {
		ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		 this.parametroDaoImpl = (ParametroDaoImpl)appContext.getBean("parametroDaoImpl");
	}	
	
	public ParametroNegImpl(ParametroDaoImpl parametroDaoImpl) {
		super();
		this.parametroDaoImpl = parametroDaoImpl;
	}

	public ParametroNegImpl() {
		super();
	}

	@Override
	public Parametro ObtenerParametroxCodigo(String codigo) {
		if(parametroDaoImpl == null)
			parametroDaoImpl = (ParametroDaoImpl)appContext.getBean("parametroDaoImpl");
		Parametro parametro = parametroDaoImpl.ObtenerParametroxCodigo(codigo);
		return parametro;
	}

	@Override
	public Boolean GuardarParametro(Parametro parametro) {
		if(parametroDaoImpl == null)
			parametroDaoImpl = (ParametroDaoImpl)appContext.getBean("parametroDaoImpl");
		Boolean resultado = parametroDaoImpl.GuardarParametro(parametro);
		return resultado;
	}

}
