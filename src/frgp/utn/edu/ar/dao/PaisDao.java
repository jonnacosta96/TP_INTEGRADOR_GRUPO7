package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.*;

public interface PaisDao {

	public List<Pais> obtenerListadoPaises(boolean estado);
}
