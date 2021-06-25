package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.LocalidadDao;
import frgp.utn.edu.ar.entidades.Localidad;

public class LocalidadDaoImpl implements LocalidadDao{

	@Override
	public List<Localidad> obtenerListadoLocalidades(boolean estado) {
		
		Conexion cn = new Conexion();
		Session session = cn.abrirConexion();
		
		String query = "FROM Localidad loc WHERE loc.estadoLocalidad = 1";
		List<Localidad> lista = (List<Localidad>)session.createQuery(query).list();
		
		cn.cerrarSession();

		return lista;
	}

}
