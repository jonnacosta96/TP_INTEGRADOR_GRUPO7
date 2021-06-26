package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import frgp.utn.edu.ar.entidades.TipoCuenta;
import frgp.utn.edu.ar.negocio.TipoCuentaNeg;
import frgp.utn.edu.ar.daoImpl.TipoCuentaDaoImpl;

public class TipoCuentaNegImpl implements TipoCuentaNeg {
	
	TipoCuentaDaoImpl tipoCuentaDaoImpl = new TipoCuentaDaoImpl();

	@Override
	public List<TipoCuenta> ObtenerListadoTiposCuenta(boolean estado) {
		List<TipoCuenta> lista = tipoCuentaDaoImpl.ObtenerListadoTiposCuenta(estado);
		return lista;
	}

	@Override
	public TipoCuenta ObtenerTipoCuenta(String codigo) {
		TipoCuenta tipoCuenta = tipoCuentaDaoImpl.ObtenerTipoCuenta(codigo);
		return tipoCuenta;
	}

}
