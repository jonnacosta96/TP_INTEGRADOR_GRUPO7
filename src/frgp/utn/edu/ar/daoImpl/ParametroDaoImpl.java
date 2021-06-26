package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.ParametroDao;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Parametro;

public class ParametroDaoImpl implements ParametroDao {

	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
	@Override
	public Parametro ObtenerParametroxCodigo(String codigo) {
		
		Parametro parametro = (Parametro)appContext.getBean("parametro");
		
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			String query = "FROM Parametro pm WHERE pm.id = :codigo";
		
			parametro = (Parametro) session.createQuery(query)
						.setParameter("codigo", codigo)
						.uniqueResult();
			
			session.getTransaction().commit();
			
			cn.cerrarSession();
		}
		catch(Exception ex) {
			return null;
		}
		
		return parametro;
	}

	@Override
	public Boolean GuardarParametro(Parametro parametro) {
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			session.saveOrUpdate(parametro);
			
			session.getTransaction().commit();
			
			cn.cerrarSession();
		}
		catch(Exception ex) {
			return false;
		}

		
		return true;
	}

}
