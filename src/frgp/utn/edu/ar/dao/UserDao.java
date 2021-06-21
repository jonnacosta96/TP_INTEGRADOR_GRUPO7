package frgp.utn.edu.ar.dao;

import frgp.utn.edu.ar.entidades.Login;
import frgp.utn.edu.ar.entidades.Usuario;

public interface UserDao {

	void register(Usuario user);
	
	Usuario validateUser(Login login);
}
