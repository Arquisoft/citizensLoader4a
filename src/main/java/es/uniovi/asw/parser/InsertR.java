package es.uniovi.asw.parser;

import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.dbupdate.InsertP;
import es.uniovi.asw.model.Citizen;

import java.util.List;

/**
 * Created by Pelayo García Lartategui on 09/02/2017.
 * Implementacion puerto R insersción base de datos
 */
public class InsertR implements Insert {


    @Override
    public void insert(List<Citizen> ciudadanos) {
         new InsertP().insert(ciudadanos);
    }
}
