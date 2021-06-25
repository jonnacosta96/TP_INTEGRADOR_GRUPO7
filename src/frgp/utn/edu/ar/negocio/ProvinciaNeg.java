package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidades.Provincia;

public interface ProvinciaNeg {

	public List<Provincia> obtenerListadoProvincias(boolean estado);
}
