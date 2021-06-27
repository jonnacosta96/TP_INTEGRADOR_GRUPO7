package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.TransaccionDao;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Transaccion;

public class TransaccionDaoImpl implements TransaccionDao{

	@Override
	public boolean GenerarTransaccion(Transaccion transac) {
		
		try {
			Conexion cn = new Conexion();
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			session.saveOrUpdate(transac);
			session.getTransaction().commit();
			
			cn.cerrarSession();	
			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
		
	}

	@Override
	public List<Transaccion> ObtenerListadoTransaccionesxCuenta(Cuenta cuenta) {
		try {
			Conexion cn = new Conexion();
			Session session = cn.abrirConexion();
			
			String query = "FROM Transaccion t WHERE t.cuentaAsoc = :cuenta AND t.estadoTransaccion = 1";
			
			List<Transaccion> lista = (List<Transaccion>) session.createQuery(query).setParameter("cuenta", cuenta).list();
			
			cn.cerrarSession();	
			
			return lista;
		}
		catch(Exception ex) {
			return null;
		}
	}

}
