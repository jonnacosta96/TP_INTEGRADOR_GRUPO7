package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.TransaccionDao;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Transaccion;

public class TransaccionDaoImpl implements TransaccionDao{
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	@Override
	public boolean GenerarTransaccion(Transaccion transac) {
		
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			session.saveOrUpdate(transac);
			session.getTransaction().commit();
			
			cn.cerrarSession();	
			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
		
	}

	@Override
	public List<Transaccion> ObtenerListadoTransaccionesxCuenta(Cuenta cuenta) {
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			String query = "FROM Transaccion t WHERE t.cuentaAsoc = :cuenta AND t.estadoTransaccion = 1";
			
			List<Transaccion> lista = (List<Transaccion>) session.createQuery(query).setParameter("cuenta", cuenta).list();
			
			cn.cerrarSession();	
			
			return lista;
		}
		catch(Exception ex) {
			return null;
		}
	}

}
