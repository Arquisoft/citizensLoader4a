package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.model.Citizen;

/**
 * Lee el fichero de Excel con los datos de una lista de ciudadanos.
 */
public interface ReadList {
	public List<Citizen> read(String path);
}
