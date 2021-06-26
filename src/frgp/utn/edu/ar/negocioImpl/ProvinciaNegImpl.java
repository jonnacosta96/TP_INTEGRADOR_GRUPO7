package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.daoImpl.ProvinciaDaoImpl;
import frgp.utn.edu.ar.entidades.Provincia;
import frgp.utn.edu.ar.negocio.ProvinciaNeg;

public class ProvinciaNegImpl implements ProvinciaNeg{
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private ProvinciaDaoImpl provDaoImpl = (ProvinciaDaoImpl)appContext.getBean("provinciaDaoImpl");

	@Override
	public List<Provincia> obtenerListadoProvincias(boolean estado) {
		
		List<Provincia> lista = provDaoImpl.obtenerListadoProvincias(estado);
		
		return lista;
	}
	
	

}
