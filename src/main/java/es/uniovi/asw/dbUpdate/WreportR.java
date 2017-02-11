package es.uniovi.asw.dbUpdate;

import es.uniovi.asw.reportWritter.WreportP;
import es.uniovi.asw.reportWritter.WriteReport;

/**
 * Created by Pelayo Garcia Lartategui on 10/02/2017.
 */
public class WreportR implements WriteReport{

    @Override
    public void report(String... problemas) {
        new WreportP().report(problemas);
    }
}




