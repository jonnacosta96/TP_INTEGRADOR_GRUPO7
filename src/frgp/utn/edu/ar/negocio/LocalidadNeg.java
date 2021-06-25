package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidades.Localidad;

public interface LocalidadNeg {
	
	public List<Localidad> obtenerListadoLocalidades(boolean estado);

}
