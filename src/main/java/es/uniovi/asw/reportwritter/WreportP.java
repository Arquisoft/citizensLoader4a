package es.uniovi.asw.reportwritter;


import java.util.logging.Logger;

/**
 * Añade a los datos la hora y la fecha.
 */
public class WreportP implements WriteReport {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


	public WreportP() {


	}

	@Override
	public void report(String... problemas) {

		for (String problema : problemas)
			LOGGER.info(problema);

	}
}










































