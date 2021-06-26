package frgp.utn.edu.ar.dao;

import frgp.utn.edu.ar.entidades.Parametro;

public interface ParametroDao {
	public Parametro ObtenerParametroxCodigo(String codigo);
	public Boolean GuardarParametro(Parametro parametro);
}
