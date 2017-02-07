package es.uniovi.asw.dbUpdate;

import es.uniovi.asw.model.Citizen;

/**
 * Recibe un objeto con la información para insertar en la base de datos.
 */
public interface Insert {
	
	Citizen insertCitizen(Citizen citizen);
}
