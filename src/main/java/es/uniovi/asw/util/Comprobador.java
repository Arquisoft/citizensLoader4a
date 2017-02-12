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
			if (!Character.isLetter(c) && !Character.isWhitespace(c))
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
	public static boolean esEmailCorrecto(String prueba){
		if (prueba == null) {
			return false;
		}
		String[] nombreYmail = prueba.split("@");
		if(nombreYmail.length != 2){ //Correo incorrecto, no cumple xxx@xxx
			return false;
		}
		String parteMail = nombreYmail[1];
		/*
		String[] mail = parteMail.split(".");
		if(mail.length != 2){ //Mail incorrecto, no cumple ...@xxx.xxx
			return false;
		}
		*/
		if(!parteMail.contains(".")){
			return false;
		}
			
		return true;
		
	}
	
	public static boolean esAddressCorrecto(String prueba){
		if (prueba == null) {
			return false;
		}
		String[] ad = prueba.split(" ");
		if(ad.length < 2){ //Correo incorrecto, no cumple xxx@xxx
			return false;
		}
		return true;
		
	}
	
	/**
	 * Este método hace que salte la excepcion en el parser, asi que no va
	 * @param prueba
	 * @return
	 */
/*	public static boolean fechaCorrecta(String prueba){
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
	}*/

	/**
	 * 
	 * @param birth
	 * @return
	 */
	public static boolean esFecha(String birth) {
		String[] a=birth.split("/");
		if(a.length==3 && esTodoDigitos(a[0]) && esTodoDigitos(a[1]) && esTodoDigitos(a[2]))
			return true;
		return false;
	}

}
