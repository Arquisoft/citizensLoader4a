package es.uniovi.asw.util;


/**
 * Clase comprobadora de entradas
 */
public class Comprobador {
	
	public final static String DATE_FORMAT = "dd/MM/yyyy";

	public static boolean esTodoTexto(String prueba) {
		if (prueba == null || prueba.equals("")) {
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
		if (prueba == null || prueba.equals("")) {
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
		if (prueba == null || prueba.equals("")) {
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
		return parteMail.contains(".");

		
	}
	
	public static boolean emailNoVacio(String email){
		if(email == null || email.equals("")){
			return false;
		}
		return true;
	}
	
	public static boolean esAddressCorrecto(String prueba){
		if (prueba == null || prueba.equals("")) {
			return false;
		}
		String[] ad = prueba.split(" ");
		if(ad.length < 2){ //Correo incorrecto, no cumple xxx@xxx
			return false;
		}
		return true;
		
	}
	

	/**
	 * 
	 * @param birth
	 * @return
	 */
	public static boolean esFecha(String birth) {
		String[] a=birth.split("/");
		return a.length==3 && esTodoDigitos(a[0]) && esTodoDigitos(a[1]) && esTodoDigitos(a[2]);

	}

}
