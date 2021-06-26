package frgp.utn.edu.ar.negocioImpl;

import frgp.utn.edu.ar.dao.ParametroDao;
import frgp.utn.edu.ar.daoImpl.ParametroDaoImpl;
import frgp.utn.edu.ar.entidades.Parametro;

public class ParametroNegImpl implements ParametroDao {

	ParametroDaoImpl parametroDaoImpl = new ParametroDaoImpl();
	
	@Override
	public Parametro ObtenerParametroxCodigo(String codigo) {
		
		Parametro parametro = parametroDaoImpl.ObtenerParametroxCodigo(codigo);
		return parametro;
	}

	@Override
	public Boolean GuardarParametro(Parametro parametro) {
		Boolean resultado = parametroDaoImpl.GuardarParametro(parametro);
		return resultado;
	}

}
