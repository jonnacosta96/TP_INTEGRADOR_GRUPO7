package frgp.utn.edu.ar.negocioImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.daoImpl.TipoCuentaDaoImpl;
import frgp.utn.edu.ar.daoImpl.TransaccionDaoImpl;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.TipoTransaccion;
import frgp.utn.edu.ar.entidades.Transaccion;
import frgp.utn.edu.ar.negocio.TransaccionNeg;

public class TransaccionNegImpl implements TransaccionNeg{
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
	
	private TransaccionDaoImpl transacDaoImpl = (TransaccionDaoImpl)appContext.getBean("transaccionDaoImpl");
	private CuentaNegImpl cuentaNegImpl = (CuentaNegImpl)appContext.getBean("cuentaNegImpl");

	@Override
	public boolean GenerarTransferencia(Cuenta ctaOrigen, Cuenta ctaDestino,float monto) {

		
		boolean estadoTransaccion1 = false;
		boolean estadoTransaccion2 = false;
		String descripcion = "";
		
		//GENERO LAS TRANSACCIONES.
		Transaccion transacCtaOrigen = (Transaccion)appContext.getBean("transaccion");
		Transaccion transacCtaDestino = (Transaccion)appContext.getBean("transaccion");
		
		descripcion = ctaDestino.getCliente().getNombre() + " " + ctaDestino.getCliente().getApellido()+ "-Cta: " + ctaDestino.getNroCuenta();
		transacCtaOrigen.setCuentaAsoc(ctaOrigen);
		transacCtaOrigen.setDescripcion("Transferencia realizada a " + descripcion);
		transacCtaOrigen.setSaldo(monto);
		transacCtaOrigen.setFechaTransaccion(LocalDate.now());
		TipoTransaccion tt1 = (TipoTransaccion)appContext.getBean("TipoTransaccion");
		tt1.setIdTipoTransaccion(2);
		tt1.setDescripcion("Debito");
		tt1.setEstadoTipoTransaccion(true);
		transacCtaOrigen.setTipoTransaccion(tt1);
		transacCtaOrigen.setEstadoTransaccion(true);
		
		estadoTransaccion1 = transacDaoImpl.GenerarTransaccion(transacCtaOrigen);
		
		descripcion = ctaOrigen.getCliente().getNombre() + " " + ctaOrigen.getCliente().getApellido()+ "-Cta: " + ctaOrigen.getNroCuenta();
		transacCtaDestino.setCuentaAsoc(ctaDestino);
		transacCtaDestino.setDescripcion("Transferencia recibida de " + descripcion);
		transacCtaDestino.setSaldo(monto);
		transacCtaDestino.setFechaTransaccion(LocalDate.now());
		TipoTransaccion tt2 = (TipoTransaccion)appContext.getBean("TipoTransaccion");
		tt2.setIdTipoTransaccion(1);
		tt2.setDescripcion("Credito");
		tt2.setEstadoTipoTransaccion(true);
		transacCtaDestino.setTipoTransaccion(tt2);
		transacCtaDestino.setEstadoTransaccion(true);
		
		estadoTransaccion2 = transacDaoImpl.GenerarTransaccion(transacCtaDestino);
		
		//GENERO LOS CAMBIOS DE MONTOS EN LAS CUENTAS.
		ctaOrigen.setSaldo(ctaOrigen.getSaldo() - monto);
		ctaDestino.setSaldo(ctaDestino.getSaldo() + monto);
		
		boolean estadoCuentaOrigen = cuentaNegImpl.GuardarCuenta(ctaOrigen);
		boolean estadoCuentaDestino = cuentaNegImpl.GuardarCuenta(ctaDestino);
		
		if(estadoTransaccion1==true && estadoTransaccion2==true && estadoCuentaOrigen == true && estadoCuentaDestino == true) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public List<Transaccion> ObtenerListadoTransaccionesxCuenta(Cuenta cuenta) {
		
		List<Transaccion> lista = transacDaoImpl.ObtenerListadoTransaccionesxCuenta(cuenta);
		
		return lista;
	}

	@Override
	public List<Transaccion> ObtenerListadoTransaccionesxCliente(Cliente cli) {
		
		ArrayList<Transaccion> lista = new ArrayList<Transaccion>();
		int contador = 0;
		
		for(Cuenta cuenta : cuentaNegImpl.ObtenerListadoCuentasxCliente(cli)) 
		{
			contador = 1;
			for(Transaccion t : transacDaoImpl.ObtenerListadoTransaccionesxCuenta(cuenta))
			{
				if(contador == 4) {
					break;
				}
				else {
					lista.add(t);
					contador++;
				}
			}

		}
		
		return lista;
	}

	@Override
	public boolean GenerarTransferenciaInicial(Cuenta ctaDestino, float monto) {
		
		boolean estadoTransaccion = false;
		String descripcion = "";
		
		//GENERO LAS TRANSACCIONES.
		Transaccion transacCtaDestino = (Transaccion)appContext.getBean("transaccion");
		
		descripcion = "Regalo de bienvenida";
		transacCtaDestino.setCuentaAsoc(ctaDestino);
		transacCtaDestino.setDescripcion(descripcion);
		transacCtaDestino.setSaldo(monto);
		transacCtaDestino.setFechaTransaccion(LocalDate.now());
		TipoTransaccion tt2 = (TipoTransaccion)appContext.getBean("TipoTransaccion");
		tt2.setIdTipoTransaccion(1);
		tt2.setDescripcion("Credito");
		tt2.setEstadoTipoTransaccion(true);
		transacCtaDestino.setTipoTransaccion(tt2);
		transacCtaDestino.setEstadoTransaccion(true);
		
		estadoTransaccion = transacDaoImpl.GenerarTransaccion(transacCtaDestino);
		
		ctaDestino.setSaldo(ctaDestino.getSaldo() + monto);
		
		boolean estadoCuentaDestino = cuentaNegImpl.GuardarCuenta(ctaDestino);
		
		if(estadoTransaccion == true &&estadoCuentaDestino == true) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
