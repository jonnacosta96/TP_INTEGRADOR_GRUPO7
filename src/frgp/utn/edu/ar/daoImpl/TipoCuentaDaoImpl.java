package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.Conexion;
import frgp.utn.edu.ar.dao.TipoCuentaDao;
import frgp.utn.edu.ar.entidades.Cuenta;
import frgp.utn.edu.ar.entidades.Pais;
import frgp.utn.edu.ar.entidades.TipoCuenta;

public class TipoCuentaDaoImpl implements TipoCuentaDao {

	@Override
	public List<TipoCuenta> ObtenerListadoTiposCuenta(boolean estado) {
		Conexion cn = new Conexion();
		
		Session session = cn.abrirConexion();
		
		String query = "FROM TipoCuenta p WHERE p.estadoTipoCuenta = 1";
		
		List<TipoCuenta> lista = (List<TipoCuenta>) session.createQuery(query).list();
				
		cn.cerrarSession();
		
		return lista;
	}

	@Override
	public TipoCuenta ObtenerTipoCuenta(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
