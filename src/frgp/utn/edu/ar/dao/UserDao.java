package frgp.utn.edu.ar.dao;

import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.entidades.User;

public interface UserDao {

	void register(User user);
	
	User validateUser(Login login);
}
