package es.uniovi.asw.parser;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.personalletter.MensajePersonalizado;
import es.uniovi.asw.personalletter.SingletonTextWritter;
import es.uniovi.asw.util.exception.CitizenException;
import org.apache.commons.cli.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {
	private static final Logger log = Logger.getLogger(Parser.class.getName());
	private String[] args = null;
	private Options options = new Options();

	private final static String HELP_KEY = "h";
	private final static String READ_EXCEL_KEY = "e";
	private final static String READ_TXT_KEY = "t";
	private final static String SEND_PDF_KEY = "spdf";
	private final static String SEND_PLAIN_TEXT_KEY = "spt";
	private final static String SEND_WORD_KEY = "sword";

	private List<Citizen> ciudadanosLeidos = null;
	private String docummentName = "";

	public Parser(String[] args) {
		this.args = args;
		createOptions();
	}

	public void parse() throws CitizenException {
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = null;

		try {
			cmd = parser.parse(options, args);
			if (cmd.hasOption(HELP_KEY)) {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("sb server", options);
			}
			if (cmd.hasOption(READ_EXCEL_KEY)) {
				docummentName = getDocumentName(cmd.getArgList().get(0));
				ciudadanosLeidos = new RListExcel().read(cmd.getArgList().get(0));
			}
			if (cmd.hasOption(READ_TXT_KEY)) {
				docummentName = getDocumentName(cmd.getArgList().get(0));
				ciudadanosLeidos = new RListTXT().read(cmd.getArgList().get(0));
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
		}
		docummentName = "";
		ciudadanosLeidos = null;
	}

	private void createOptions() {
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
		System.exit(0);
	}
	
	private String getDocumentName(String n){
		String[] cachos = n.split(".");
		return cachos[0];
	}

}
