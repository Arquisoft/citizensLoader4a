package es.uniovi.asw.dbupdate;

import es.uniovi.asw.reportwritter.WreportP;
import es.uniovi.asw.reportwritter.WriteReport;

/**
 * Created by Pelayo Garcia Lartategui on 10/02/2017.
 */
public class WreportR implements WriteReport{

    @Override
    public void report(String... problemas) {
        new WreportP().report(problemas);
    }
}




