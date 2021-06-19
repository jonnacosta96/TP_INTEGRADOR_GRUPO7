package frgp.utn.edu.ar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.entidades.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User validateUser(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

}
