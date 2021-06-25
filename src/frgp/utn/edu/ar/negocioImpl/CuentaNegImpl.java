package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import frgp.utn.edu.ar.daoImpl.ClienteDaoImpl;
import frgp.utn.edu.ar.daoImpl.CuentaDaoImpl;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.negocio.CuentaNeg;

public class CuentaNegImpl implements CuentaNeg {
	
	private CuentaDaoImpl cuentaDaoImpl = new CuentaDaoImpl();

	@Override
	public List<Cuenta> ObtenerListadoCuentas(boolean estado) {
		
		List<Cuenta> lista  = cuentaDaoImpl.ObtenerListadoCuentas(estado);
		
		return lista;
	}

	@Override
	public Cuenta ObtenerCuentaxNroCuenta(int nroCuenta) {

		Cuenta cuenta = cuentaDaoImpl.ObtenerCuentaxNroCuenta(nroCuenta);
		
		return cuenta;
		
	}

	@Override
	public boolean GuardarCuenta(Cuenta cuenta) {
		
		boolean Resultado = cuentaDaoImpl.GuardarCuenta(cuenta);
		
		return Resultado;
	}

}
