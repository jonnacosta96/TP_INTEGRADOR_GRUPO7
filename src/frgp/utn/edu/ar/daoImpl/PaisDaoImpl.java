package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.PaisDao;
import frgp.utn.edu.ar.entidades.Pais;

public class PaisDaoImpl implements PaisDao{
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

	@Override
	public List<Pais> obtenerListadoPaises(boolean estado) {
		
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			
			Session session = cn.abrirConexion();
			
			String query = "FROM Pais p WHERE p.estadoPais = 1";
			
			List<Pais> lista = (List<Pais>) session.createQuery(query).list();
					
			cn.cerrarSession();
			
			return lista;
		}
		catch(Exception ex) {
			return null;
		}

	}
	
	

}
