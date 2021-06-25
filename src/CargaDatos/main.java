package CargaDatos;

import java.time.LocalDate;
import java.util.Calendar;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.entidades.*;

public class main {

	public static void main(String[] args) {
		
		Parametro param = new Parametro("LAST_CBU","",1234567900);
		
		Pais pais1 = new Pais("Argentina", true);
		Pais pais2 = new Pais("Uruguay", true);
		
		Provincia prov1 = new Provincia("Buenos Aires", true);
		Provincia prov2 = new Provincia("Santa Fe", true);
		Provincia prov3 = new Provincia("Entre Rios", true);
		
		Localidad loc1 = new Localidad("Don Torcuato", true);
		Localidad loc2 = new Localidad("Pacheco", true);
		Localidad loc3 = new Localidad("San Miguel", true);
		
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
		Usuario user11 = new Usuario("clientePrueba","clientePrueba","clientePrueba@mail.com","Customer",true);
		Usuario user12 = new Usuario("admin","admin","admin@mail.com","Admin",true);
		
		Cliente client1 = new Cliente(40379478, "Masculino", pais1, LocalDate.now(), "Calle Prueba 1", prov1, loc1, user1, true, "Tobias","Olea");
		Cliente client2 = new Cliente(39561226, "Masculino", pais1, LocalDate.now(), "Calle Prueba 2", prov2, loc3, user2, true, "Jonathan","Costa");
		Cliente client3 = new Cliente(25926366, "Masculino", pais2, LocalDate.now(), "Calle Prueba 3", prov3, loc2, user3, true, "Ricardo","Mollo");
		Cliente client4 = new Cliente(27122807, "Femenino", pais1, LocalDate.now(), "Calle Prueba 4", prov1, loc1, user4, true, "David","Gilmour");
		Cliente client5 = new Cliente(17506588, "Femenino", pais1, LocalDate.now(), "Calle Prueba 5", prov2, loc3, user5, true, "Jimmy","Page");
		Cliente client6 = new Cliente(29655222, "Masculino", pais2, LocalDate.now(), "Calle Prueba 6", prov3, loc2, user6, true, "Jimi","Hendrix");
		Cliente client7 = new Cliente(40525111, "Masculino", pais1, LocalDate.now(), "Calle Prueba 7", prov1, loc1, user7, true, "Eddie","Van Halen");
		Cliente client8 = new Cliente(5499299, "Femenino", pais1, LocalDate.now(), "Calle Prueba 8", prov2, loc2, user8, true, "Eric","Clapton");
		Cliente client9 = new Cliente(40379479, "Masculino", pais2, LocalDate.now(), "Calle Prueba 9", prov3, loc3, user9, true, "Gustavo","Cerati");
		Cliente client10 = new Cliente(14960360, "Femenino", pais2, LocalDate.now(), "Calle Prueba 10", prov3, loc2, user10, true, "Usuario","Cliente");
		Cliente client11 = new Cliente(31556813, "Masculino", pais1, LocalDate.now(), "Calle Prueba 10", prov3, loc2, user11, true, "UsuarioPrueba","Cliente");
		
		Empleado empleado = new Empleado("Usuario","Admin", user12);
		
		
		Moneda moneda1 = new Moneda("1", "Dolar EEUU",true);
		Moneda moneda2 = new Moneda("2", "Peso Argentino",true);
		
		TipoCuenta tipocuenta1 = new TipoCuenta("1", moneda1, "Cuenta en Pesos",true);
		TipoCuenta tipocuenta2 = new TipoCuenta("2", moneda2, "Cuenta en USD",true);
		
		
		Cuenta cuenta1 = new Cuenta(client1, "Cuenta Personal", tipocuenta1, 1234567800, Calendar.getInstance().getTime(), 10000, true);
		Cuenta cuenta2 = new Cuenta(client1, "Cuenta Laboral", tipocuenta2, 1234567801, Calendar.getInstance().getTime(), 15000, true);
		Cuenta cuenta3 = new Cuenta(client1, "Cuenta Personal", tipocuenta2, 1234567802, Calendar.getInstance().getTime(), 20000, true);
		Cuenta cuenta4 = new Cuenta(client1, "Cuenta Personal", tipocuenta1,1234567803, Calendar.getInstance().getTime(), 10000, true);
		Cuenta cuenta5 = new Cuenta(client5, "Caja de Ahorro", tipocuenta1,1234567804, Calendar.getInstance().getTime(), 64000, true);
		Cuenta cuenta6 = new Cuenta(client6, "Felipe Melo", tipocuenta1,1234567805, Calendar.getInstance().getTime(), 100000, true);
		Cuenta cuenta7 = new Cuenta(client7, "Cuenta inversiones", tipocuenta1,1234567806, Calendar.getInstance().getTime(), 160000, true);
		Cuenta cuenta8 = new Cuenta(client8, "Cuenta Personal", tipocuenta2,1234567807, Calendar.getInstance().getTime(), 6000, true);
		Cuenta cuenta9 = new Cuenta(client2, "Cuenta Personal", tipocuenta2, 1234567808, Calendar.getInstance().getTime(), 6000, true);
		Cuenta cuenta10 = new Cuenta(client6, "Felipe Melo 2", tipocuenta2, 1234567809, Calendar.getInstance().getTime(), 6000, true);
		
		TipoTransaccion tipotransac1 = new TipoTransaccion("Credito", true);
		TipoTransaccion tipotransac2 = new TipoTransaccion("Debito", true);
		
		Transaccion transaccion1 = new Transaccion(cuenta1, "Pago de Haberes", tipotransac1, 50000, Calendar.getInstance().getTime(), true);
		Transaccion transaccion2 = new Transaccion(cuenta1, "Alquiler", tipotransac2, 1000, Calendar.getInstance().getTime(), true);
		Transaccion transaccion3 = new Transaccion(cuenta4, "Cobro de Prestaciones", tipotransac1, 50000, Calendar.getInstance().getTime(), true);
		Transaccion transaccion4 = new Transaccion(cuenta4, "Pago de Aguinaldo", tipotransac1, 1000, Calendar.getInstance().getTime(), true);
		Transaccion transaccion5 = new Transaccion(cuenta4, "Pago de Haberes", tipotransac1, 50000, Calendar.getInstance().getTime(), true);
		Transaccion transaccion6 = new Transaccion(cuenta7, "Pago de prestamo", tipotransac2, 1000, Calendar.getInstance().getTime(), true);
		Transaccion transaccion7 = new Transaccion(cuenta8, "Transferencia Recibida", tipotransac1, 50000, Calendar.getInstance().getTime(), true);
		Transaccion transaccion8 = new Transaccion(cuenta10, "Transferencia Realizada", tipotransac2, 5680, Calendar.getInstance().getTime(), true);
		Transaccion transaccion9 = new Transaccion(cuenta2, "Deposito Bancario", tipotransac1, 50000, Calendar.getInstance().getTime(), true);
		Transaccion transaccion10 = new Transaccion(cuenta2, "Servicio Luz Edenor", tipotransac2, 1870, Calendar.getInstance().getTime(), true);
		
		Conexion cn = new Conexion();

		Session session = cn.abrirConexion();
		
		session.beginTransaction();
		
		session.saveOrUpdate(param);
		
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
		session.saveOrUpdate(user12);
		
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
		session.saveOrUpdate(client11);
		
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
