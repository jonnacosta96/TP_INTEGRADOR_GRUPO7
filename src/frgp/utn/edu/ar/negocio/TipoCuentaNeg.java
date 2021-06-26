package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidades.TipoCuenta;

public interface TipoCuentaNeg {

	public List<TipoCuenta> obtenerListadoTipoCuentas(boolean estado);
}
