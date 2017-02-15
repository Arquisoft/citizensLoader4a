package es.uniovi.asw.parser;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.util.Exception.CustomException;

import java.util.List;

/**
 * Lee el fichero con los datos de una lista de ciudadanos.
 */
public interface ReadList {

    public List<Citizen> read(String path) throws  CustomException;

}
