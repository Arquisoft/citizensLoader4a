package es.uniovi.asw.parser.differentParsers;

import java.util.List;


import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.RListExcel;
import es.uniovi.asw.parser.RListTXT;
import es.uniovi.asw.reportwritter.SingletonReporter;
import es.uniovi.asw.util.exception.CitizenException;

/**
 * Parser creado a gusto.
 * 
 * @author Javier Castro
 * 
 * Comandos admitidos:
 * 
 * 	- readExcel nombreFich
 * 	- readTxt nombreFich
 *
 */
public class MyParser {
	String[] args;
	List<Citizen> ciudadanos;



	public MyParser(String realArgs) {
		realArgs.replace("([-])\\1+", "");// Para borrar las rayas.
		this.args = realArgs.split(" ");
	}
	public MyParser(String[] realArgs) {
		String var = realArgs[0];
		String[] myArgs = var.split(" ");
		for(String s : myArgs){
			s.replace("-", "");
		}
		this.args = myArgs;
	}

	public void parse() {
		try{
		if (args.length > 1) { // Al menos dos parametros.
			for (int i = 0; i < args.length; i++) {
				String command = args[i];
				switch (command) {
				
				case "readExcel":
					leerExcel(args[i+1]);
					i++;
					break;
				case "readtxt": 
					leerTxt(args[i+1]);
					i++;
					break;
				
				}
			}
		}
		} catch(CitizenException e){
			SingletonReporter.getInstance().getWreportP().report("Ha ocurrido un error interno al ejecutar los comandos");
		}
	}

	private void leerExcel(String path) throws CitizenException {
		ciudadanos = new RListExcel().read(path);
	}

	private void leerTxt(String path)  throws CitizenException{
		ciudadanos = new RListTXT().read(path);
	}
}
