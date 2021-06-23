package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.ClienteDao;
import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.entidades.Cliente;

public class ClienteDaoImpl implements ClienteDao {

	@Override
	public List<Cliente> ObtenerListadoClientes(boolean estado) {
		
		Conexion cn = new Conexion();
		Session session = cn.abrirConexion();
		
		String query = "FROM Cliente cli WHERE cli.estadoCliente = 1";
		List<Cliente> lista = (List<Cliente>)session.createQuery(query).list();
		
		cn.cerrarSession();
		
		return lista;
	}

}
