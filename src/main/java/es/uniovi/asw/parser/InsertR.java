package es.uniovi.asw.parser;

import es.uniovi.asw.dbUpdate.Insert;
import es.uniovi.asw.dbUpdate.InsertP;
import es.uniovi.asw.model.Citizen;

import java.util.List;

/**
 * Created by Pelayo García Lartategui on 09/02/2017.
 */
public class InsertR implements Insert {


    @Override
    public void insert(List<Citizen> ciudadanos) {
         new InsertP().insert(ciudadanos);
    }
}
