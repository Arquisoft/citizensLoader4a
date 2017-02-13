package es.uniovi.asw.reportwritter;

/**
 * Recibe los datos para escribir en el fichero de log.
 */
public interface WriteReport {
	

	public void report(String... problemas);
	
}
