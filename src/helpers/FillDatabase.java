package helpers;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.entidades.Usuario;

public class FillDatabase {
	public static void GenerateRecords() {
		Conexion cn = new Conexion();
	    Session session = cn.abrirConexion();
	    session.beginTransaction();
	    
	    session.saveOrUpdate(new Usuario(
  	      "admin", "admin", "Admin", "User", "admin@user.com", "Admin", true
  	    ));
	    session.saveOrUpdate(new Usuario(
	      "customer", "customer", "Customer", "User", "customer@user.com", "Customer", true
	    ));
	    
	    session.getTransaction().commit();
	    session.close();
	}
}
