package frgp.utn.edu.ar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.UserDaoImpl;
import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.entidades.Usuario;

public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDaoImpl userDaoImpl;

	@Override
	public void register(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario validateUser(Login login) {
		
		Conexion cn = new Conexion();
	    Session session = cn.abrirConexion();
	    
	    Usuario user = (Usuario)session.createQuery(""
	    		+ "SELECT * FROM "
	    		+ "User u "
	    		+ "WHERE u.UserName=" + login.getUsername()
	    		+ "	AND u.Password="  + login.getPassword()).uniqueResult();
	    
	    
	    cn.cerrarSession();
		
		return user;
	}

}
