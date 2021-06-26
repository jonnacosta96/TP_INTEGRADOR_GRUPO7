package frgp.utn.edu.ar.negocioImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.dao.ParametroDao;
import frgp.utn.edu.ar.daoImpl.ParametroDaoImpl;
import frgp.utn.edu.ar.daoImpl.ProvinciaDaoImpl;
import frgp.utn.edu.ar.entidades.Parametro;

public class ParametroNegImpl implements ParametroDao {

	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private ParametroDaoImpl parametroDaoImpl = (ParametroDaoImpl)appContext.getBean("parametroDaoImpl");
	
	@Override
	public Parametro ObtenerParametroxCodigo(String codigo) {
		
		Parametro parametro = parametroDaoImpl.ObtenerParametroxCodigo(codigo);
		return parametro;
	}

	@Override
	public Boolean GuardarParametro(Parametro parametro) {
		Boolean resultado = parametroDaoImpl.GuardarParametro(parametro);
		return resultado;
	}

}
