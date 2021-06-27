package frgp.utn.edu.ar.negocioImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.daoImpl.TransaccionDaoImpl;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.TipoTransaccion;
import frgp.utn.edu.ar.entidades.Transaccion;
import frgp.utn.edu.ar.negocio.TransaccionNeg;

public class TransaccionNegImpl implements TransaccionNeg{
	
	private TransaccionDaoImpl transacDaoImpl = new TransaccionDaoImpl();
	private CuentaNegImpl cuentaNegImpl = new CuentaNegImpl();

	@Override
	public boolean GenerarTransferencia(Cuenta ctaOrigen, Cuenta ctaDestino,float monto) {

		
		boolean estadoTransaccion1 = false;
		boolean estadoTransaccion2 = false;
		String descripcion = "";
		
		//GENERO LAS TRANSACCIONES.
		Transaccion transacCtaOrigen = new Transaccion();
		Transaccion transacCtaDestino = new Transaccion();
		
		descripcion = ctaDestino.getCliente().getNombre() + " " + ctaDestino.getCliente().getApellido()+ "-Cta: " + ctaDestino.getNroCuenta();
		transacCtaOrigen.setCuentaAsoc(ctaOrigen);
		transacCtaOrigen.setDescripcion("Transferencia realizada a " + descripcion);
		transacCtaOrigen.setSaldo(monto);
		transacCtaOrigen.setFechaTransaccion(LocalDate.now());
		transacCtaOrigen.setTipoTransaccion(new TipoTransaccion(2, "Debito", true));
		transacCtaOrigen.setEstadoTransaccion(true);
		
		estadoTransaccion1 = transacDaoImpl.GenerarTransaccion(transacCtaOrigen);
		
		descripcion = ctaOrigen.getCliente().getNombre() + " " + ctaOrigen.getCliente().getApellido()+ "-Cta: " + ctaOrigen.getNroCuenta();
		transacCtaDestino.setCuentaAsoc(ctaDestino);
		transacCtaDestino.setDescripcion("Transferencia recibida de " + descripcion);
		transacCtaDestino.setSaldo(monto);
		transacCtaDestino.setFechaTransaccion(LocalDate.now());
		transacCtaDestino.setTipoTransaccion(new TipoTransaccion(1, "Credito", true));
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

}
