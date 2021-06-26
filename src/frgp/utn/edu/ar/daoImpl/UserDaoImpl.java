package frgp.utn.edu.ar.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.UserDao;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.entidades.Usuario;

public class UserDaoImpl implements UserDao {

	@Override
	public void register(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario validateUser(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarUsuarioxName(Usuario usu) {
		
		try {
			Conexion cn = new Conexion();
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
