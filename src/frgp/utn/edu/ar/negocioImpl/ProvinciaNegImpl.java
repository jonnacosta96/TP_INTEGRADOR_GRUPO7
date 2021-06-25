package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import frgp.utn.edu.ar.daoImpl.ProvinciaDaoImpl;
import frgp.utn.edu.ar.entidades.Provincia;
import frgp.utn.edu.ar.negocio.ProvinciaNeg;

public class ProvinciaNegImpl implements ProvinciaNeg{
	
	private ProvinciaDaoImpl provDaoImpl = new ProvinciaDaoImpl();

	@Override
	public List<Provincia> obtenerListadoProvincias(boolean estado) {
		
		List<Provincia> lista = provDaoImpl.obtenerListadoProvincias(estado);
		
		return lista;
	}
	
	

}
