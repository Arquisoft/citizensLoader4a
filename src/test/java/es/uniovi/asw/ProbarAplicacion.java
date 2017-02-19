package es.uniovi.asw;

import org.junit.Test;

import es.uniovi.asw.util.Console;

/**
 * Clase para probar la aplicacion por comandos.
 * 
 * @author Javier Castro
 *
 */
public class ProbarAplicacion {

	LoadCitizens app;
	String args;
	String filesLocation = "src/test/resources/";

	@Test
	public void leerExcel() {
		args = "readExcel " + filesLocation + "test.xlsx";
		Console.println("A leer un excel con el comando: "+args);
		
		LoadCitizens.main(args);
	}
	@Test
	public void leerTxt() {
		args = "readTxt " + filesLocation + "test.txt";
		
		Console.println("A leer un txt con el comando: "+args);
		LoadCitizens.main(args);
	}
}
