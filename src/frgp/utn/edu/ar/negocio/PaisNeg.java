package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidades.Pais;

public interface PaisNeg {
	
	public List<Pais> obtenerListadoPaises(boolean estado);
}
