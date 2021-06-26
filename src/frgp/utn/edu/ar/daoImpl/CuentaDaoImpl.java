package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.CuentaDao;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;

public class CuentaDaoImpl implements CuentaDao {

	@Override
	public List<Cuenta> ObtenerListadoCuentas(boolean estado) {
		try {
			Conexion cn = new Conexion();
			Session session = cn.abrirConexion();
			
			String query = "FROM Cuenta cue WHERE cue.activo = 1";
			List<Cuenta> lista = (List<Cuenta>)session.createQuery(query).list();
			cn.cerrarSession();
			
			return lista;
		}
		catch (Exception ex)
		{
			return null;
		}
	}

	@Override
	public Cuenta ObtenerCuentaxNroCuenta(int nroCuenta) {
		Cuenta cuenta = new Cuenta();
		
		try {
			Conexion cn = new Conexion();
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			String query = "FROM Cuenta cue WHERE cue.nroCuenta = :nrocuenta";
		
			cuenta = (Cuenta) session.createQuery(query)
						.setParameter("nrocuenta", nroCuenta)
						.uniqueResult();
			
			session.getTransaction().commit();
			
			cn.cerrarSession();
		}
		catch(Exception ex) {
			return null;
		}
		
		return cuenta;
	}

	@Override
	public boolean GuardarCuenta(Cuenta cuenta) {
		try {
			Conexion cn = new Conexion();
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			session.saveOrUpdate(cuenta);
			
			session.getTransaction().commit();
			
			cn.cerrarSession();
		}
		catch(Exception ex) {
			return false;
		}

		return true;
	}

	@Override
	public Long CantidadCuentasxNroCliente(Cliente cliente) {
		
		Long cantidadCuentas;
		
		try {
			Conexion cn = new Conexion();
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			String hql = "SELECT COUNT(c) FROM Cuenta c WHERE c.cliente = :cliente";
			
			cantidadCuentas = (Long)session.createQuery(hql)
	    			.setParameter("cliente", cliente)
	    			.uniqueResult();
			
			session.getTransaction().commit();
			
			cn.cerrarSession();
		}
		catch(Exception ex) {
			return null;
		}
		
		return cantidadCuentas;
	}

}
