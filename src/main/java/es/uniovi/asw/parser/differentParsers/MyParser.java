package es.uniovi.asw.parser.differentParsers;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.RListExcel;
import es.uniovi.asw.parser.RListTXT;
import es.uniovi.asw.personalletter.MensajePersonalizado;
import es.uniovi.asw.personalletter.SingletonTextWritter;
import es.uniovi.asw.reportwritter.SingletonReporter;
import es.uniovi.asw.util.exception.CitizenException;

import java.util.List;

/**
 * Parser creado a gusto.
 * 
 * @author Javier Castro
 * 
 *         Comandos admitidos:
 * 
 *         - readExcel nombreFich - readTxt nombreFich
 *
 */
public class MyParser {
	private String[] args;
	private List<Citizen> ciudadanos;
	private String docName;

	public MyParser(String realArgs) {
		realArgs.replace("([-])\\1+", "");// Para borrar las rayas.

		this.args = realArgs.split(" ");
		ciudadanos = null;
		docName = null;
	}

	public MyParser(String[] realArgs) {
		this.args = realArgs;
		ciudadanos = null;
	}

	public void parse() throws CitizenException {
		boolean admitido = false;
		//Console.println("\nMyParser informa:\n\t"+argsToString());
		//try {
			if (args.length >= 1) { // Al menos dos parametros.
				for (int i = 0; i < args.length; i++) {
					String command = args[i];
					switch (command) {

					case "readExcel":
						leerExcel(args[i + 1]);
						docName = getDocumentName(args[ i + 1]);
						i++;
						admitido = true;
						break;
					case "readTxt":
						leerTxt(args[i + 1]);
						docName = getDocumentName(args[ i + 1]);
						i++;
						admitido = true;
						break;
					case "sendPDF":
						if(!(ciudadanos == null || ciudadanos.size() == 0) && admitido){
							docName = getDocumentName(args[ i + 1]);
							sendPdf();
						}
						break;
					case "sendTXT":
						if(!(ciudadanos == null || ciudadanos.size() == 0) && admitido){
							docName = getDocumentName(args[ i + 1]);
							sendTXT();
						}
						break;
					case "sendDOC":
						if(!(ciudadanos == null || ciudadanos.size() == 0) && admitido){
							docName = getDocumentName(args[ i + 1]);
							sendDOC();
						}
						break;
					}
				}
			}
		/*} catch (CitizenException e) {
			SingletonReporter.getInstance().getWreportP()
					.report("MyParser informa:\n-" + "Ha ocurrido un error interno al ejecutar los comandos");
			throw new CitizenException();
		}*/
		if (!admitido) {
			SingletonReporter.getInstance().getWreportP()
					.report("MyParser informa:\n-" + "Comando incorrecto! Se ha leido:\n\t" + argsToString());
			throw new CitizenException();

		}
	}

	private void leerExcel(String path) throws CitizenException {
		ciudadanos = new RListExcel().read(path);
	}

	private void leerTxt(String path) throws CitizenException {
		ciudadanos = new RListTXT().read(path);
	}
	
	private void sendPdf() throws CitizenException{
		for(Citizen c : ciudadanos){
			SingletonTextWritter.getInstance().getPDFTextrWitter().createDocument(docName, MensajePersonalizado.getMessage(c));
		}
	}

	private void sendTXT() throws CitizenException{
		for(Citizen c : ciudadanos){
			SingletonTextWritter.getInstance().getPlainTextWritter().createDocument(docName, MensajePersonalizado.getMessage(c));
		}
	}

	private void sendDOC() throws CitizenException{
		for(Citizen c : ciudadanos){
			SingletonTextWritter.getInstance().getWordTextWritter().createDocument(docName, MensajePersonalizado.getMessage(c));
		}
	}

	private String argsToString() {
		StringBuilder sb = new StringBuilder();
		for (String s : args) {
			sb.append(s + " ");
		}
		return sb.toString();
	}
	
	private String getDocumentName(String n){
		String[] fueraRuta = n.split("/");
		String myFile = fueraRuta[fueraRuta.length -1 ];
		//String[] cachos = myFile.split(".");
		String name = myFile.replaceAll("[.]+[a-z-A-Z]+", "");
		return name;
	}
}
