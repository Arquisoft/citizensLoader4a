package es.uniovi.asw.parser;

import java.util.List;

import org.omg.CORBA.COMM_FAILURE;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.reportwritter.SingletonReporter;
import es.uniovi.asw.util.exception.CitizenException;

public class Parser2 {
	String[] args;
	List<Citizen> ciudadanos;

	private boolean LEER_EXCEL = false;
	private boolean LEER_TXT = false;
	private boolean MANDAR_PDF = false;
	private boolean MANDAR_WORD = false;
	private boolean MANDAR_PLAINTEXT = false;
	private boolean ARCHIVO = false;

	public Parser2(String realArgs) {
		realArgs.replace("([-])\\1+", "");// Para borrar las rayas.
		this.args = realArgs.split(" ");
	}
	public Parser2(String[] realArgs) {
		String var = realArgs[0];
		String[] myArgs = var.split(" ");
		for(String s : myArgs){
			s.replace("-", "");
		}
		this.args = myArgs;
	}

	public void parse() {
		try{
		boolean hasCommand = false;
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
