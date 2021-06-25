package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import frgp.utn.edu.ar.daoImpl.PaisDaoImpl;
import frgp.utn.edu.ar.entidades.Pais;
import frgp.utn.edu.ar.negocio.PaisNeg;

public class PaisNegImpl implements PaisNeg{

	private PaisDaoImpl paisDaoImpl = new PaisDaoImpl();
	
	@Override
	public List<Pais> obtenerListadoPaises(boolean estado) {
		
		List<Pais> lista = paisDaoImpl.obtenerListadoPaises(estado);
		
		return lista;
	}
	
	

}
