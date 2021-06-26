package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.daoImpl.LocalidadDaoImpl;
import frgp.utn.edu.ar.entidades.Localidad;
import frgp.utn.edu.ar.negocio.LocalidadNeg;

public class LocalidadNegImpl implements LocalidadNeg{
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private LocalidadDaoImpl locDaoImpl = (LocalidadDaoImpl)appContext.getBean("localidadDaoImpl");
	
	@Override
	public List<Localidad> obtenerListadoLocalidades(boolean estado) {
		
		List<Localidad> lista = locDaoImpl.obtenerListadoLocalidades(estado);
		
		return lista;
	}

}
