package helpers;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.entidades.User;

public class FillDatabase {
	public static void GenerateRecords() {
		Conexion cn = new Conexion();
	    Session session = cn.abrirConexion();
	    session.beginTransaction();
	    
	    session.saveOrUpdate(new User(
	      "admin", "admin", "Admin", "User", "admin@user.com", "Alvear 575", 123456, "Admin"
	    ));
	    session.saveOrUpdate(new User(
  	      "customer", "customer", "Customer", "User", "customer@user.com", "Alvear 575", 132456, "Customer"
  	    ));
	    
	    session.getTransaction().commit();
	    session.close();
	}
}
