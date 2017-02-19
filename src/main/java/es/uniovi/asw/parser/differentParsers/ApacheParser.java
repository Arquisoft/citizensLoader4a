package es.uniovi.asw.parser.differentParsers;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.RListExcel;
import es.uniovi.asw.parser.RListTXT;
import es.uniovi.asw.personalletter.MensajePersonalizado;
import es.uniovi.asw.personalletter.SingletonTextWritter;
import es.uniovi.asw.util.exception.CitizenException;
import org.apache.commons.cli.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApacheParser {
	/*private static final Logger log = Logger.getLogger(ApacheParser.class.getName());
	private String[] args = null;
	private Options options = new Options();

	public final static String HELP_KEY = "h";
	public final static String READ_EXCEL_KEY = "e";
	public final static String READ_TXT_KEY = "t";
	public final static String SEND_PDF_KEY = "spdf";
	public final static String SEND_PLAIN_TEXT_KEY = "spt";
	public final static String SEND_WORD_KEY = "sword";

	private List<Citizen> ciudadanosLeidos = null;
	private String docummentName = "";

	public ApacheParser(String[] args) {
		this.args = args;
		createOptions();
	}

	public void parse(){
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = null;
		String var = args[0];
		String[] newArgs = var.split(" ");
		try {
			cmd = parser.parse(options, newArgs);
			if (cmd.hasOption(HELP_KEY)) {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("sb server", options);
			}
			if (cmd.hasOption(READ_EXCEL_KEY)) {
				docummentName = getDocumentName(newArgs[1]);
				ciudadanosLeidos = new RListExcel().read(newArgs[1]);
			}
			if (cmd.hasOption(READ_TXT_KEY)) {
				docummentName =  getDocumentName(newArgs[1]);
				ciudadanosLeidos = new RListTXT().read(newArgs[1]);
			}
			if (cmd.hasOption(SEND_PDF_KEY)) {
				if (docummentName != "" && ciudadanosLeidos != null) {
					for (Citizen c : ciudadanosLeidos) {
						SingletonTextWritter.getInstance().getPDFTextrWitter().createDocument(docummentName,
								MensajePersonalizado.getMessage(c));
					}
				}
			}
			if (cmd.hasOption(SEND_PLAIN_TEXT_KEY)) {
				if (docummentName != "" && ciudadanosLeidos != null) {
					for (Citizen c : ciudadanosLeidos) {
						SingletonTextWritter.getInstance().getPlainTextWritter().createDocument(docummentName,
								MensajePersonalizado.getMessage(c));
					}
				}
			}
			if (cmd.hasOption(SEND_WORD_KEY)) {
				if (docummentName != "" && ciudadanosLeidos != null) {
					for (Citizen c : ciudadanosLeidos) {
						SingletonTextWritter.getInstance().getWordTextWritter().createDocument(docummentName,
								MensajePersonalizado.getMessage(c));
					}
				}
			}

			else {
				log.log(Level.SEVERE, "MIssing v option");
				help();
			}

		} catch (ParseException e) {
			log.log(Level.SEVERE, "Failed to parse comand line properties", e);
			help();
		} catch (CitizenException ce){
			log.log(Level.WARNING, "Ha ocurrido un error al cargar el fichero.", ce);
		}
		docummentName = "";
		ciudadanosLeidos = null;
	}

	private void createOptions() {
//		Option excelRead = OptionBuilder.hasArgs(1).withArgName("Excel file to read").withDescription("Leer el archivo excel especificado.").create(READ_EXCEL_KEY);
//		options.addOption(excelRead);
		options.addOption(HELP_KEY, "help", false, "Mostrar ayuda.");
		options.addOption(READ_EXCEL_KEY, "excel", true, "Cargar fichero excel");
		options.addOption(READ_TXT_KEY, "txt", true, "Cargar fichero txt");
		options.addOption(SEND_PDF_KEY, "PDF", true, "Envia una carta pdf a todos los ciudadanos nuevos.");
		options.addOption(SEND_PLAIN_TEXT_KEY, "Plain text", true,
				"Envia una carta pen texto plano a todos los ciudadanos nuevos.");
		options.addOption(SEND_WORD_KEY, "Word", true, "Envia una carta en Word a todos los ciudadanos nuevos.");

	}

	private void help() {
		// This prints out some help
		HelpFormatter formater = new HelpFormatter();
		formater.printHelp("Main", options);
		//System.exit(0);
	}
	
	private String getDocumentName(String n){
		String[] fueraRuta = n.split("/");
		String myFile = fueraRuta[fueraRuta.length -1 ];
		//String[] cachos = myFile.split(".");
		String name = myFile.replaceAll("[.]+[a-z-A-Z]+", "");
		return name;
	}
*/
}
