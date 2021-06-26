package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.ProvinciaDao;
import frgp.utn.edu.ar.entidades.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao {

	@Override
	public List<Provincia> obtenerListadoProvincias(boolean estado) {
		
		try {
			Conexion cn = new Conexion();
			Session session = cn.abrirConexion();
			
			String query = "FROM Provincia prov WHERE prov.estadoProvincia = 1";
			List<Provincia> lista = (List<Provincia>) session.createQuery(query).list();

			cn.cerrarSession();
			
			return lista;
		}
		catch(Exception ex) {
			return null;
		}

	}
	
	
}
