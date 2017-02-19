package es.uniovi.asw.parser.adapter;

/**
 * Clase adaptadora de parsers.
 * 
 * @author Javier Castro
 *
 *         Se trata de una clase general para el uso de los adapters. Amite los
 *         siguientes comandos:
 *
 *         - readExcel fichname -> permite cargar y leer el fichero "fichname"
 *         .xlsx
 * 
 *         - readTxt filename -> permite cargar y leer el fichero "fichname"
 *         .txt
 * 
 * 			- 
 */
public interface GeneralParser {
	/*
	 * 
	 */
	public void parse(String... args);
}
