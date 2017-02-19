package es.uniovi.asw.parser.adapter;

import es.uniovi.asw.util.exception.CitizenException;

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
 *         - sendPDF -> Manda una carta en PDF a todos los ciudadanos leidos. Es
 *         necesario poner la lectura antes, es decir: readXXX filename sendPDF
 */
public interface GeneralParser {
	/*
	 * 
	 */
	 void parse(String... args) throws CitizenException;
}
