package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.LocalidadDao;
import frgp.utn.edu.ar.entidades.Localidad;

public class LocalidadDaoImpl implements LocalidadDao{
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
	@Override
	public List<Localidad> obtenerListadoLocalidades(boolean estado) {
		
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			String query = "FROM Localidad loc WHERE loc.estadoLocalidad = 1";
			List<Localidad> lista = (List<Localidad>)session.createQuery(query).list();
			
			cn.cerrarSession();

			return lista;
		}
		catch(Exception ex) {
			return null;
		}
	}

}
