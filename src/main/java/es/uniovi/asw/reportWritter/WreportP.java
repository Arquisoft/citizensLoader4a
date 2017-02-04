package es.uniovi.asw.reportWritter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Añade a los datos la hora y la fecha.
 */
public class WreportP implements WriteReport{
	
	String contenidoFichero;
	String nombreFich;
	
	public WreportP(String nombreFich, String contenido){
		this.contenidoFichero = contenido;
		String[] cachosNombre = nombreFich.split(".");
		this.nombreFich = "error"+cachosNombre[0]+".log";
	}
	
	public void createErrorLogFile() {
		try {
			File logFile = new File("src/test/resources/" + this.nombreFich);
			FileWriter fileWriter = new FileWriter(logFile);
			fileWriter.write(this.contenidoFichero);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {

		}
	}
}
