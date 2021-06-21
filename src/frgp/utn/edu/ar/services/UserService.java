package frgp.utn.edu.ar.services;
import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.entidades.Usuario;

public interface UserService {
	
	void register(Usuario user);
	Usuario validateUser(Login login);
}
