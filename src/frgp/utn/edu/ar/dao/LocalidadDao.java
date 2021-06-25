package frgp.utn.edu.ar.dao;

import java.util.List;
import frgp.utn.edu.ar.entidades.*;

public interface LocalidadDao {
	
	public List<Localidad> obtenerListadoLocalidades(boolean estado);

}
