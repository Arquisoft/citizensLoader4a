package es.uniovi.asw.dbUpdate;

import es.uniovi.asw.model.Citizen;

import java.util.List;


/**
 * Recibe un objeto con la información para insertar en la base de datos.
 */
public interface Insert {
	
	void insert(List<Citizen> ciudadanos);
}
