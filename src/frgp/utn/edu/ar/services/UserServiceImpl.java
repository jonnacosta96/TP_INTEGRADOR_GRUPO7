package frgp.utn.edu.ar.services;

import org.springframework.beans.factory.annotation.Autowired;

import frgp.utn.edu.ar.dao.UserDaoImpl;
import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.entidades.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDaoImpl userDaoImpl;

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
