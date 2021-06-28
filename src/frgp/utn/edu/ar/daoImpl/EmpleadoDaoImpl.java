package frgp.utn.edu.ar.daoImpl;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.EmpleadoDao;
import frgp.utn.edu.ar.entidades.Empleado;
import frgp.utn.edu.ar.entidades.Usuario;

public class EmpleadoDaoImpl implements EmpleadoDao {

	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
	@Override
	public Empleado ObtenerEmpleadoXUserId(Usuario usuario) {
		
		Conexion cn = (Conexion)appContext.getBean("conexion");
		Session session = cn.abrirConexion();
		
		try {
			String hql = "from Empleado e where e.usuario = :usuario";
			
			Empleado empleado = (Empleado)session.createQuery(hql)
					.setParameter("usuario", usuario)
					.uniqueResult();
			
			return empleado;
			
		}
		catch(Exception ex) {
			return null;
		}
		
	}

}
