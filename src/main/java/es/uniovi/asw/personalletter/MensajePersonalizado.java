package es.uniovi.asw.personalletter;

import es.uniovi.asw.model.Citizen;

public class MensajePersonalizado {
	
	public final static String SALUDO = "Bienvenido, ";
	public final static String CONTENIDO1 = "\nLe comunicamos que ha sido correctamente introducido en el sistema.";
	public final static String CONTENIDO2 = "\nSus datos de usuario son los siguientes: ";
	public final static String USUARIO = "\n\t\t-USUARIO : ";
	public final static String CONTRASEÑA = "\n\t\t-CONTRASEÑA : ";
	public final static String DESPEDIDA = "\n\tUn saludo, el Ayuntamiento.";
	static String message;
	

	public static String getMessage(Citizen c){
		generateMessage(c);
		
		return message;
	}
	private static void generateMessage(Citizen c){
		/*
		 * Hacer el mensaje con los datos del citizen
		 */
		StringBuilder sb = new StringBuilder();
		sb.append(SALUDO + c.getNombre() + " "+ c.getApellidos());
		sb.append(CONTENIDO1);
		sb.append(CONTENIDO2);
		sb.append(USUARIO+c.getEmail());
		sb.append(CONTRASEÑA+c.getContrasenaNC());
		sb.append(DESPEDIDA);
		message = sb.toString();
	}
}
