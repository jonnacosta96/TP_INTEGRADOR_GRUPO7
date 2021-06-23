package helpers;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.entidades.Moneda;
import frgp.utn.edu.ar.entidades.TipoCuenta;
import frgp.utn.edu.ar.entidades.Usuario;

public class FillDatabase {
	public static void GenerateRecords() {
		/*Conexion cn = new Conexion();
	    Session session = cn.abrirConexion();
	    session.beginTransaction();
	    
	    session.saveOrUpdate(new Usuario(
  	      "admin", "admin", "Admin", "User", "admin@user.com", "Admin", true
  	    ));
	    session.saveOrUpdate(new Usuario(
	      "customer", "customer", "Customer", "User", "customer@user.com", "Customer", true
	    ));
	    Moneda moneda1 = new Moneda("ARS","Peso Argentino",true);
	    Moneda moneda2 = new Moneda("USD","Dolar Estadounidense",true);
	    session.saveOrUpdate(moneda1);
	    session.saveOrUpdate(moneda2);
	    session.saveOrUpdate(new TipoCuenta("CA-ARS",moneda1,"Caja de ahorro en ARS"));
	    session.saveOrUpdate(new TipoCuenta("CA-USD",moneda2,"Caja de ahorro en USD"));
	    
	    session.getTransaction().commit();
	    session.close();*/
	}
}
