package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.CuentaDao;
import frgp.utn.edu.ar.entidades.Cliente;
import frgp.utn.edu.ar.entidades.Cuenta;

public class CuentaDaoImpl implements CuentaDao {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");

	@Override
	public List<Cuenta> ObtenerListadoCuentas(boolean estado) {
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
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
		
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			String query = "FROM Cuenta cue WHERE cue.nroCuenta = :nrocuenta";
		
			Cuenta cuenta = (Cuenta) session.createQuery(query)
						.setParameter("nrocuenta", nroCuenta)
						.uniqueResult();
			
			session.getTransaction().commit();
			
			cn.cerrarSession();
			
			return cuenta;
		}
		catch(Exception ex) {
			return null;
		}
		
		
	}

	@Override
	public boolean GuardarCuenta(Cuenta cuenta) {
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
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
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			String hql = "SELECT COUNT(c) FROM Cuenta c WHERE c.cliente = :cliente and c.activo = 1";
			
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

	@Override
	public List<Cuenta> ObtenerListadoCuentasxCliente(Cliente cliente) {
		try {
			Conexion cn = (Conexion)appContext.getBean("conexion");
			Session session = cn.abrirConexion();
			
			String query = "FROM Cuenta cue WHERE cue.cliente = :cliente and cue.activo = 1 ";
			List<Cuenta> lista = (List<Cuenta>)session.createQuery(query)
									.setParameter("cliente", cliente)
									.list();
			cn.cerrarSession();
			
			return lista;
		}
		catch (Exception ex)
		{
			return null;
		}
	}

}
