package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidades.TipoCuenta;

public interface TipoCuentaNeg {
	public List<TipoCuenta> ObtenerListadoTiposCuenta(boolean estado);
	public TipoCuenta ObtenerTipoCuenta(String codigo);
}
