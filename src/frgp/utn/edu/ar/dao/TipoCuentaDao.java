package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.TipoCuenta;

public interface TipoCuentaDao {
	
	public List<TipoCuenta> ObtenerListadoTiposCuenta(boolean estado);
	public TipoCuenta ObtenerTipoCuenta(String codigo);

}
