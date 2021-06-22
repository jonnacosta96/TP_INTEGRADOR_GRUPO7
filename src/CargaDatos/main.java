package CargaDatos;

import java.time.LocalDate;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Localidad;
import frgp.utn.edu.ar.entidades.Moneda;
import frgp.utn.edu.ar.entidades.Pais;
import frgp.utn.edu.ar.entidades.Provincia;
import frgp.utn.edu.ar.entidades.TipoCuenta;
import frgp.utn.edu.ar.entidades.TipoTransaccion;
import frgp.utn.edu.ar.entidades.Transaccion;

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
		
		
		//Cliente client1 = new Cliente(1001, 39986516, "Masculino", pais1, LocalDate.now(), "Calle Prueba 1", prov1, loc1, true);
		Cliente client2 = new Cliente(1002, 39561226, "Masculino", pais1, LocalDate.now(), "Calle Prueba 2", prov2, loc3, true);
		Cliente client3 = new Cliente(1003, 25926366, "Masculino", pais2, LocalDate.now(), "Calle Prueba 3", prov3, loc2, true);
		Cliente client4 = new Cliente(1004, 27122807, "Femenino", pais1, LocalDate.now(), "Calle Prueba 4", prov1, loc1, true);
		Cliente client5 = new Cliente(1005, 17506588, "Femenino", pais1, LocalDate.now(), "Calle Prueba 5", prov2, loc3, true);
		Cliente client6 = new Cliente(1006, 29655222, "Masculino", pais2, LocalDate.now(), "Calle Prueba 6", prov3, loc2, true);
		Cliente client7 = new Cliente(1007, 40525111, "Masculino", pais1, LocalDate.now(), "Calle Prueba 7", prov1, loc1, true);
		Cliente client8 = new Cliente(1008, 34666888, "Femenino", pais1, LocalDate.now(), "Calle Prueba 8", prov2, loc2, true);
		Cliente client9 = new Cliente(1009, 22335879, "Masculino", pais2, LocalDate.now(), "Calle Prueba 9", prov3, loc3, true);
		Cliente client10 = new Cliente(1010, 31359726, "Femenino", pais2, LocalDate.now(), "Calle Prueba 10", prov3, loc2, true);
		
		
		Moneda moneda1 = new Moneda("1", "Dolar EEUU");
		Moneda moneda2 = new Moneda("2", "Peso Argentino");
		
		TipoCuenta tipocuenta1 = new TipoCuenta("1", moneda1, "Cuenta en Pesos");
		TipoCuenta tipocuenta2 = new TipoCuenta("2", moneda2, "Cuenta en USD");
		
		
		//Cuenta cuenta1 = new Cuenta(2001, client1, "Cuenta Personal", tipocuenta1, "47489864989481", LocalDate.now(), 10000, true);
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
		
		//Transaccion transaccion1 = new Transaccion(8001, cuenta1, "Pago de Haberes", tipotransac1, 50000, LocalDate.now(), true);
		//Transaccion transaccion2 = new Transaccion(8002, cuenta1, "Alquiler", tipotransac2, 1000, LocalDate.now(), true);
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
		
		//session.save(client1);
		session.save(client2);
		session.save(client3);
		session.save(client4);
		session.save(client5);
		session.save(client6);
		session.save(client7);
		session.save(client8);
		session.save(client9);
		session.save(client10);
		
		//session.save(cuenta1);
		session.save(cuenta2);
		session.save(cuenta3);
		session.save(cuenta4);
		session.save(cuenta5);
		session.save(cuenta6);
		session.save(cuenta7);
		session.save(cuenta8);
		session.save(cuenta9);
		session.save(cuenta10);
		

		session.save(tipotransac1);
		session.save(tipotransac2);
		
		//session.save(transaccion1);
		//session.save(transaccion2);
		session.save(transaccion3);
		session.save(transaccion4);
		session.save(transaccion5);
		session.save(transaccion6);
		session.save(transaccion7);
		session.save(transaccion8);
		session.save(transaccion9);
		session.save(transaccion10);

    	session.getTransaction().commit();
    	session.close();
	}

}
