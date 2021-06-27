package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Transaccion;

public interface TransaccionNeg{
	
	public boolean GenerarTransferencia(Cuenta ctaOrigen, Cuenta ctaDestino,float monto);
	public List<Transaccion> ObtenerListadoTransaccionesxCuenta(Cuenta cuenta);
	public List<Transaccion> ObtenerListadoTransaccionesxCliente(Cliente cli);
}
