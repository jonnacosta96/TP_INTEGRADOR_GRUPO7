package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidades.Provincia;

public interface ProvinciaDao {
	
	public List<Provincia> obtenerListadoProvincias(boolean estado);

}
