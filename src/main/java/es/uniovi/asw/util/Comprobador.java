package es.uniovi.asw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comprobador {
	
	public final static String DATE_FORMAT = "dd/MM/yyyy";

	public static boolean esTodoTexto(String prueba) {
		if (prueba == null) {
			return false;
		}
		char[] caracteres = prueba.toCharArray();
		for (char c : caracteres) {
			if (!Character.isLetter(c))
				return false;
		}
		return true;
	}

	public static boolean esTodoDigitos(String prueba) {
		if (prueba == null) {
			return false;
		}
		char[] caracteres = prueba.toCharArray();
		for (char c : caracteres) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}
	
	public static boolean fechaCorrecta(String prueba){
		if(prueba == null){
			return false;
		}
		Date date;
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		try {
			date = sdf.parse(prueba);
			if(!prueba.equals(sdf.format(date))){
				date = null;
			}
		} catch (ParseException e) {
			//e.printStackTrace();
			Console.println("EXCEPCION SALTADA AL COMPROBAR EL FORMATO DE LA FECHA");
			date = null;
		}
		
		if(date == null){
			return false;
		}
		return true;
	}

}
