package es.uniovi.asw.reportWritter;


public class GenerateLogText {
	
	/**
	 * 
	 * @param actualLoggingText
	 * @param name
	 * @param surname
	 * @param email
	 * @param birth
	 * @param address
	 * @param nationality
	 * @param nif
	 * @param actualrow
	 * @return
	 */
	public static boolean completeTextForLog(StringBuilder actualLoggingText, boolean name, boolean surname, boolean email,
			boolean birth, boolean address, boolean nationality, boolean nif, int actualrow) {

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
			actualLoggingText.append("\tCiudadano no creado, por favor, arregle los errores.");
		} else {
			actualLoggingText.append("\t" + ErrorTypes.OK);
		}
		actualLoggingText.append("\n");
		return todoOK;
	}

}
