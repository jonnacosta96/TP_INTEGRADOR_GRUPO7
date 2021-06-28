package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Transaccion;

public interface TransaccionDao {
	
	public boolean GenerarTransaccion(Transaccion transac);
	public List<Transaccion> ObtenerListadoTransaccionesxCuenta(Cuenta cuenta);
	public Long ContarTransaccionesRealizadas();
	
}
