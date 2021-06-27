package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;

public interface CuentaNeg {

	public List<Cuenta> ObtenerListadoCuentas(boolean estado);
	public Cuenta ObtenerCuentaxNroCuenta(int nroCuenta);
	public List<Cuenta> ObtenerListadoCuentasxCliente(Cliente cli);
	public boolean GuardarCuenta(Cuenta cuenta);
	public Long CantidadCuentasxNroCliente(Cliente cliente);
	public List<Cuenta> ObtenerListadoCuentasxCliente(Cliente cliente);
}
