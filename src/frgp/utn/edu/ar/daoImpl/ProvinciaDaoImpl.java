package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.ProvinciaDao;
import frgp.utn.edu.ar.entidades.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

	@Override
	public List<Provincia> obtenerListadoProvincias(boolean estado) {
		
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			String query = "FROM Provincia prov WHERE prov.estadoProvincia = 1";
			List<Provincia> lista = (List<Provincia>) session.createQuery(query).list();

			cn.cerrarSession();
			
			return lista;
		}
		catch(Exception ex) {
			return null;
		}

	}
	
	
}
