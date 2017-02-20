package es.uniovi.asw.dbupdate;

import es.uniovi.asw.reportwritter.SingletonReporter;
import es.uniovi.asw.reportwritter.WriteReport;

/**
 * Created by Pelayo Garcia Lartategui on 10/02/2017.
 * Puerto R para la escritura de reportes
 */
public class WreportR implements WriteReport{

    @Override
    public void report(String... problemas) {
        //new WreportP().report(problemas);
    	SingletonReporter.getInstance().getWreportP().report(problemas);
    }
}




