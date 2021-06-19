package frgp.utn.edu.ar.services;
import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.entidades.User;

public interface UserService {
	
	void register(User user);
	User validateUser(Login login);
}
