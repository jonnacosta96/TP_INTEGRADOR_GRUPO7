package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.PaisDao;
import frgp.utn.edu.ar.entidades.Pais;

public class PaisDaoImpl implements PaisDao{

	@Override
	public List<Pais> obtenerListadoPaises(boolean estado) {
		
		try {
			Conexion cn = new Conexion();
			
			Session session = cn.abrirConexion();
			
			String query = "FROM Pais p WHERE p.estadoPais = 1";
			
			List<Pais> lista = (List<Pais>) session.createQuery(query).list();
					
			cn.cerrarSession();
			
			return lista;
		}
		catch(Exception ex) {
			return null;
		}

	}
	
	

}
