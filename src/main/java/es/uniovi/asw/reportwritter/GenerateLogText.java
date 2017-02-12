package es.uniovi.asw.reportwritter;

public class GenerateLogText {

	/**
	 * Metodo sobre cargado que comprueba los siguientes atributos del Citizen y
	 * genera un mensaje para un Logger.
	 * 
	 * Éste método se puede utilizar en un Excel o similar ya que pide la fila
	 * en la que se está leyendo el ciudadano.
	 * 
	 * Los parámetro para su correcto funcionamiento siguen este orden en el
	 * docuemnto:
	 * 
	 * Nombre, apellidos, email, birth, address, nationality, nif
	 * 
	 * @param actualLoggingText
	 *            StringBuilder en el que se carga el mensaje.
	 * @param name
	 *            Nombre del ciudadano
	 * @param surname
	 *            Apellido del ciudadano
	 * @param email
	 *            Email del ciudadano
	 * @param birth
	 *            Fecha de nacimiento del ciudadano
	 * @param address
	 *            Dirección del ciudadano
	 * @param nationality
	 *            Nacionalidad del ciudadano
	 * @param nif
	 *            Número de identificacion del ciudadano
	 * @param actualrow
	 *            Columna actual del documento.
	 * @return
	 */
	public static boolean completeTextForLog(StringBuilder actualLoggingText, boolean name, boolean surname,
			boolean email, boolean birth, boolean address, boolean nationality, boolean nif, int actualrow) {

		boolean todoOK = true;
		actualLoggingText.append("Ciudadano línea -> " + actualrow + "\n");
		if (!name) {
			actualLoggingText.append("\t" + ErrorTypes.NAME_ERROR + " column " + 0 + "\n");
			todoOK = false;
		}
		if (!surname) {
			actualLoggingText.append("\t" + ErrorTypes.SURNAME_ERROR + " column " + 1 + "\n");
			todoOK = false;
		}
		if (!email) {
			actualLoggingText.append("\t" + ErrorTypes.EMAIL_ERROR + " column " + 2 + "\n");
			todoOK = false;
		}
		if (!address) {
			actualLoggingText.append("\t" + ErrorTypes.ADDRESS_ERROR + " column " + 4 + "\n");
			todoOK = false;
		}
		if (!birth) {
			actualLoggingText.append("\t" + ErrorTypes.DATE_ERROR + " column " + 3 + "\n");
			todoOK = false;
		}
		if (!nationality) {
			actualLoggingText.append("\t" + ErrorTypes.NATIONALITY_ERROR + " column " + 5 + "\n");
			todoOK = false;
		}
		if (!nif) {
			actualLoggingText.append("\t" + ErrorTypes.NIF_ERROR + "column " + 6 + "\n");
			todoOK = false;
		}
		if (!todoOK) {
			actualLoggingText.append("\t" + ErrorTypes.NOT_ADDED_CITIZEN);
		} else {
			actualLoggingText.append("\t" + ErrorTypes.OK);
		}
		actualLoggingText.append("\n");
		return todoOK;
	}
	
	/**
	 * Metodo sobre cargado que comprueba los siguientes atributos del Citizen y
	 * genera un mensaje para un Logger.
	 * 
	 * Éste método se puede utilizar en un Excel o similar ya que pide la fila
	 * en la que se está leyendo el ciudadano.
	 * 
	 * Los parámetro para su correcto funcionamiento siguen este orden en el
	 * docuemnto:
	 * 
	 * Nombre, apellidos, email, birth, address, nationality, nif
	 * 
	 * @param actualLoggingText
	 *            StringBuilder en el que se carga el mensaje.
	 * @param name
	 *            Nombre del ciudadano
	 * @param surname
	 *            Apellido del ciudadano
	 * @param email
	 *            Email del ciudadano
	 * @param birth
	 *            Fecha de nacimiento del ciudadano
	 * @param address
	 *            Dirección del ciudadano
	 * @param nationality
	 *            Nacionalidad del ciudadano
	 * @param nif
	 *            Número de identificacion del ciudadano
	 * @return
	 */
	public static boolean completeTextForLog(StringBuilder actualLoggingText, boolean name, boolean surname,
			boolean email, boolean birth, boolean address, boolean nationality, boolean nif) {

		boolean todoOK = true;
		actualLoggingText.append("Ciudadano\n");
		if (!name) {
			actualLoggingText.append("\t" + ErrorTypes.NAME_ERROR + " column " + 0 + "\n");
			todoOK = false;
		}
		if (!surname) {
			actualLoggingText.append("\t" + ErrorTypes.SURNAME_ERROR + " column " + 1 + "\n");
			todoOK = false;
		}
		if (!email) {
			actualLoggingText.append("\t" + ErrorTypes.EMAIL_ERROR + " column " + 2 + "\n");
			todoOK = false;
		}
		if (!address) {
			actualLoggingText.append("\t" + ErrorTypes.ADDRESS_ERROR + " column " + 4 + "\n");
			todoOK = false;
		}
		if (!birth) {
			actualLoggingText.append("\t" + ErrorTypes.DATE_ERROR + " column " + 3 + "\n");
			todoOK = false;
		}
		if (!nationality) {
			actualLoggingText.append("\t" + ErrorTypes.NATIONALITY_ERROR + " column " + 5 + "\n");
			todoOK = false;
		}
		if (!nif) {
			actualLoggingText.append("\t" + ErrorTypes.NIF_ERROR + "column " + 6 + "\n");
			todoOK = false;
		}
		if (!todoOK) {
			actualLoggingText.append("\t" + ErrorTypes.NOT_ADDED_CITIZEN);
		} else {
			actualLoggingText.append("\t" + ErrorTypes.OK);
		}
		actualLoggingText.append("\n");
		return todoOK;
	}

}
