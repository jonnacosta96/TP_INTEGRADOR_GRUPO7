package frgp.utn.edu.ar.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.UserDao;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.entidades.Usuario;

public class UserDaoImpl implements UserDao {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

	@Override
	public void register(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario validateUser(Login login) {
		Conexion cn = (Conexion)appContext.getBean("conexion");
	    Session session = cn.abrirConexion();
	    
	    String hql = "from Usuario u where u.username = :username and u.password = :password and u.activo = 1";
	    Usuario user = (Usuario)session.createQuery(hql)
		    		.setParameter("username", login.getUsername())
		    		.setParameter("password", login.getPassword())
		    		.uniqueResult();
	    
	    
		return user;
	}

	@Override
	public boolean eliminarUsuarioxName(Usuario usu) {
		
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			String query = "Delete Usuario users WHERE users.username = :name";
			
			session.createQuery(query).setParameter("name", usu.getUsername());
			
			cn.cerrarSession();
			
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

}
