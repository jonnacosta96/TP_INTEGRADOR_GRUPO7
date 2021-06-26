package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import frgp.utn.edu.ar.daoImpl.TipoCuentaDaoImpl;
import frgp.utn.edu.ar.entidades.TipoCuenta;
import frgp.utn.edu.ar.negocio.TipoCuentaNeg;

public class TipoCuentaNegImpl implements TipoCuentaNeg{
	
	private TipoCuentaDaoImpl tcDaoImpl = new TipoCuentaDaoImpl();

	@Override
	public List<TipoCuenta> obtenerListadoTipoCuentas(boolean estado) {

		List<TipoCuenta> lista = tcDaoImpl.obtenerListadoTipoCuentas(estado);
		
		return lista;
	}

}
