package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.ParametroDao;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Parametro;

public class ParametroDaoImpl implements ParametroDao {

	@Override
	public Parametro ObtenerParametroxCodigo(String codigo) {
		
		Parametro parametro = new Parametro();
		
		try {
			Conexion cn = new Conexion();
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			String query = "FROM Parametro pm WHERE pm.id = :codigo";
		
			parametro = (Parametro) session.createQuery(query)
						.setParameter("codigo", codigo)
						.uniqueResult();
			
			session.getTransaction().commit();
			
			cn.cerrarSession();
		}
		catch(Exception ex) {
			return null;
		}
		
		return parametro;
	}

	@Override
	public Boolean GuardarParametro(Parametro parametro) {
		try {
			Conexion cn = new Conexion();
			Session session = cn.abrirConexion();
			
			session.beginTransaction();
			
			session.saveOrUpdate(parametro);
			
			session.getTransaction().commit();
			
			cn.cerrarSession();
		}
		catch(Exception ex) {
			return false;
		}

		
		return true;
	}

}
