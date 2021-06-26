package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;

public interface CuentaDao {

	public List<Cuenta> ObtenerListadoCuentas(boolean estado);
	public Cuenta ObtenerCuentaxNroCuenta(int nroCuenta);
	public boolean GuardarCuenta(Cuenta cuenta);
	public Long CantidadCuentasxNroCliente(Cliente cliente);
}
