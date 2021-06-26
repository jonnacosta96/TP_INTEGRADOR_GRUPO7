package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.daoImpl.PaisDaoImpl;
import frgp.utn.edu.ar.daoImpl.ParametroDaoImpl;
import frgp.utn.edu.ar.entidades.Pais;
import frgp.utn.edu.ar.negocio.PaisNeg;

public class PaisNegImpl implements PaisNeg{

	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	private PaisDaoImpl paisDaoImpl = (PaisDaoImpl)appContext.getBean("paisDaoImpl");
	
	@Override
	public List<Pais> obtenerListadoPaises(boolean estado) {
		
		List<Pais> lista = paisDaoImpl.obtenerListadoPaises(estado);
		
		return lista;
	}
	
	

}
