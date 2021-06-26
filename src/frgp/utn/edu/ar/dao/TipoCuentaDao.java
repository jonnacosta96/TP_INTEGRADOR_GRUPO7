package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.TipoCuenta;

public interface TipoCuentaDao {
	
	public List<TipoCuenta> obtenerListadoTipoCuentas(boolean estado);

}
