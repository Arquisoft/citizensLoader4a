package es.uniovi.asw.reportWritter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Añade a los datos la hora y la fecha.
 */
public class WreportP implements WriteReport {

	String contenidoFichero;
	String nombreFich;
	String path;

	public WreportP(String nombreFich, String contenido) {
		this.contenidoFichero = contenido;
		this.nombreFich = "error" + nombreFich + ".log";
		path = "src/test/resources/" + this.nombreFich;
	}

	public void createErrorLogFile() {
		FileWriter fileWriter = null;
		BufferedWriter bf = null;
		try {
			new File(path);
			fileWriter = new FileWriter(path);
			bf = new BufferedWriter(fileWriter);
			bf.write(contenidoFichero);
		} catch (IOException e) {

		} finally {
			try {
				if (bf != null) {
					bf.close();
				}
				if(fileWriter != null){
					fileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
