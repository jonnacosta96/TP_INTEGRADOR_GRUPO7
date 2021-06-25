package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import frgp.utn.edu.ar.daoImpl.LocalidadDaoImpl;
import frgp.utn.edu.ar.entidades.Localidad;
import frgp.utn.edu.ar.negocio.LocalidadNeg;

public class LocalidadNegImpl implements LocalidadNeg{

	private LocalidadDaoImpl locDaoImpl = new LocalidadDaoImpl();
	
	@Override
	public List<Localidad> obtenerListadoLocalidades(boolean estado) {
		
		List<Localidad> lista = locDaoImpl.obtenerListadoLocalidades(estado);
		
		return lista;
	}

}
