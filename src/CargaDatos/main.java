package CargaDatos;

import java.time.LocalDate;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.entidades.*;

public class main {

	public static void main(String[] args) {
		
System.out.println(LocalDate.now().toString());	
		
		Pais pais1 = new Pais(1, "Argentina", true);
		Pais pais2 = new Pais(2, "Uruguay", true);
		
		Provincia prov1 = new Provincia(1, "Buenos Aires", true);
		Provincia prov2 = new Provincia(2, "Santa Fe", true);
		Provincia prov3 = new Provincia(3, "Entre Rios", true);
		
		Localidad loc1 = new Localidad(1, "Don Torcuato", true);
		Localidad loc2 = new Localidad(2, "Pacheco", true);
		Localidad loc3 = new Localidad(3, "San Miguel", true);
		
		Usuario user1 = new Usuario("tolea","tolea","tolea@mail.com","Customer",true);
		Usuario user2 = new Usuario("jcosta","jcosta","jcosta@mail.com","Customer",true);
		Usuario user3 = new Usuario("rmollo","rmollo","rmollo@mail.com","Customer",true);
		Usuario user4 = new Usuario("dgilmour","dgilmour","dgilmour@mail.com","Customer",true);
		Usuario user5 = new Usuario("jpage","jpage","jpage@mail.com","Customer",true);
		Usuario user6 = new Usuario("jhendrix","jhendrix","jhendrix@mail.com","Customer",true);
		Usuario user7 = new Usuario("ehalen","ehalen","ehalen@mail.com","Customer",true);
		Usuario user8 = new Usuario("eclapton","eclapton","eclapton@mail.com","Customer",true);
		Usuario user9 = new Usuario("gcerati","gcerati","gcerati@mail.com","Customer",true);
		Usuario user10 = new Usuario("cliente","cliente","cliente@mail.com","Customer",true);
		Usuario user11 = new Usuario("admin","admin","admin@mail.com","Admin",true);
		
		Cliente client1 = new Cliente(1001, 39986516, "Masculino", pais1, LocalDate.now(), "Calle Prueba 1", prov1, loc1, user1, true, "Tobias","Olea");
		Cliente client2 = new Cliente(1002, 39561226, "Masculino", pais1, LocalDate.now(), "Calle Prueba 2", prov2, loc3, user2, true, "Jonathan","Costa");
		Cliente client3 = new Cliente(1003, 25926366, "Masculino", pais2, LocalDate.now(), "Calle Prueba 3", prov3, loc2, user3, true, "Ricardo","Mollo");
		Cliente client4 = new Cliente(1004, 27122807, "Femenino", pais1, LocalDate.now(), "Calle Prueba 4", prov1, loc1, user4, true, "David","Gilmour");
		Cliente client5 = new Cliente(1005, 17506588, "Femenino", pais1, LocalDate.now(), "Calle Prueba 5", prov2, loc3, user5, true, "Jimmy","Page");
		Cliente client6 = new Cliente(1006, 29655222, "Masculino", pais2, LocalDate.now(), "Calle Prueba 6", prov3, loc2, user6, true, "Jimi","Hendrix");
		Cliente client7 = new Cliente(1007, 40525111, "Masculino", pais1, LocalDate.now(), "Calle Prueba 7", prov1, loc1, user7, true, "Eddie","Van Halen");
		Cliente client8 = new Cliente(1008, 34666888, "Femenino", pais1, LocalDate.now(), "Calle Prueba 8", prov2, loc2, user8, true, "Eric","Clapton");
		Cliente client9 = new Cliente(1009, 22335879, "Masculino", pais2, LocalDate.now(), "Calle Prueba 9", prov3, loc3, user9, true, "Gustavo","Cerati");
		Cliente client10 = new Cliente(1010, 31359726, "Femenino", pais2, LocalDate.now(), "Calle Prueba 10", prov3, loc2, user10, true, "Usuario","Cliente");
		
		Empleado empleado = new Empleado(1001,"Usuario","Cliente", user11);
		
		
		Moneda moneda1 = new Moneda("1", "Dolar EEUU",true);
		Moneda moneda2 = new Moneda("2", "Peso Argentino",true);
		
		TipoCuenta tipocuenta1 = new TipoCuenta("1", moneda1, "Cuenta en Pesos",true);
		TipoCuenta tipocuenta2 = new TipoCuenta("2", moneda2, "Cuenta en USD",true);
		
		
		Cuenta cuenta1 = new Cuenta(2001, client1, "Cuenta Personal", tipocuenta1, "47489864989481", LocalDate.now(), 10000, true);
		Cuenta cuenta2 = new Cuenta(2002, client2, "Cuenta Laboral", tipocuenta2, "55224194641881", LocalDate.now(), 15000, true);
		Cuenta cuenta3 = new Cuenta(2003, client3, "Cuenta Personal", tipocuenta2, "85981388946681", LocalDate.now(), 20000, true);
		Cuenta cuenta4 = new Cuenta(2004, client4, "Cuenta Personal", tipocuenta1, "89771368916681", LocalDate.now(), 10000, true);
		Cuenta cuenta5 = new Cuenta(2005, client5, "Caja de Ahorro", tipocuenta1, "78943154894316", LocalDate.now(), 64000, true);
		Cuenta cuenta6 = new Cuenta(2006, client6, "Felipe Melo", tipocuenta1, "44613165887896", LocalDate.now(), 100000, true);
		Cuenta cuenta7 = new Cuenta(2007, client7, "Cuenta inversiones", tipocuenta1, "21347873156746", LocalDate.now(), 160000, true);
		Cuenta cuenta8 = new Cuenta(2008, client8, "Cuenta Personal", tipocuenta2, "54646664131486", LocalDate.now(), 6000, true);
		Cuenta cuenta9 = new Cuenta(2009, client2, "Cuenta Personal", tipocuenta2, "54646664131486", LocalDate.now(), 6000, true);
		Cuenta cuenta10 = new Cuenta(2010, client6, "Felipe Melo 2", tipocuenta2, "54646664131486", LocalDate.now(), 6000, true);
		
		TipoTransaccion tipotransac1 = new TipoTransaccion(1, "Credito", true);
		TipoTransaccion tipotransac2 = new TipoTransaccion(2, "Debito", true);
		
		Transaccion transaccion1 = new Transaccion(8001, cuenta1, "Pago de Haberes", tipotransac1, 50000, LocalDate.now(), true);
		Transaccion transaccion2 = new Transaccion(8002, cuenta1, "Alquiler", tipotransac2, 1000, LocalDate.now(), true);
		Transaccion transaccion3 = new Transaccion(8003, cuenta4, "Cobro de Prestaciones", tipotransac1, 50000, LocalDate.now(), true);
		Transaccion transaccion4 = new Transaccion(8004, cuenta4, "Pago de Aguinaldo", tipotransac1, 1000, LocalDate.now(), true);
		Transaccion transaccion5 = new Transaccion(8005, cuenta4, "Pago de Haberes", tipotransac1, 50000, LocalDate.now(), true);
		Transaccion transaccion6 = new Transaccion(8006, cuenta7, "Pago de prestamo", tipotransac2, 1000, LocalDate.now(), true);
		Transaccion transaccion7 = new Transaccion(8007, cuenta8, "Transferencia Recibida", tipotransac1, 50000, LocalDate.now(), true);
		Transaccion transaccion8 = new Transaccion(8008, cuenta10, "Transferencia Realizada", tipotransac2, 5680, LocalDate.now(), true);
		Transaccion transaccion9 = new Transaccion(8009, cuenta2, "Deposito Bancario", tipotransac1, 50000, LocalDate.now(), true);
		Transaccion transaccion10 = new Transaccion(80010, cuenta2, "Servicio Luz Edenor", tipotransac2, 1870, LocalDate.now(), true);
		
		Conexion cn = new Conexion();

		Session session = cn.abrirConexion();
		
		session.beginTransaction();
		
		session.saveOrUpdate(user1);
		session.saveOrUpdate(user2);
		session.saveOrUpdate(user3);
		session.saveOrUpdate(user4);
		session.saveOrUpdate(user5);
		session.saveOrUpdate(user6);
		session.saveOrUpdate(user7);
		session.saveOrUpdate(user8);
		session.saveOrUpdate(user9);
		session.saveOrUpdate(user10);
		session.saveOrUpdate(user11);
		
		session.saveOrUpdate(client1);
		session.saveOrUpdate(client2);
		session.saveOrUpdate(client3);
		session.saveOrUpdate(client4);
		session.saveOrUpdate(client5);
		session.saveOrUpdate(client6);
		session.saveOrUpdate(client7);
		session.saveOrUpdate(client8);
		session.saveOrUpdate(client9);
		session.saveOrUpdate(client10);
		
		session.saveOrUpdate(empleado);
		
		session.saveOrUpdate(cuenta1);
		session.saveOrUpdate(cuenta2);
		session.saveOrUpdate(cuenta3);
		session.saveOrUpdate(cuenta4);
		session.saveOrUpdate(cuenta5);
		session.saveOrUpdate(cuenta6);
		session.saveOrUpdate(cuenta7);
		session.saveOrUpdate(cuenta8);
		session.saveOrUpdate(cuenta9);
		session.saveOrUpdate(cuenta10);
		

		session.saveOrUpdate(tipotransac1);
		session.saveOrUpdate(tipotransac2);
		
		session.saveOrUpdate(transaccion1);
		session.saveOrUpdate(transaccion2);
		session.saveOrUpdate(transaccion3);
		session.saveOrUpdate(transaccion4);
		session.saveOrUpdate(transaccion5);
		session.saveOrUpdate(transaccion6);
		session.saveOrUpdate(transaccion7);
		session.saveOrUpdate(transaccion8);
		session.saveOrUpdate(transaccion9);
		session.saveOrUpdate(transaccion10);

    	session.getTransaction().commit();
    	session.close();
	}

}
