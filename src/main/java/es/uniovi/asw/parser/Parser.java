package es.uniovi.asw.parser;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Parser {
	private static final Logger log = Logger.getLogger(Parser.class.getName());
	private String[] args = null;
	private Options options = new Options();
	private OptionGroup group =  new OptionGroup();  

	public Parser(String[] args) {
		this.args = args;
		options.addOption("h", "help", false, "show help.");
		options.addOption("v", "var", true, "Here you can set parameter .");
		group.addOption(new Option("err",     "Salida estándar de errores"));  
        group.addOption(new Option("console", "Salida estándar"));  
        options.addOptionGroup(group);  
          
	}

	public void parse() {
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = null;
		int prueba;
		try {
			cmd = parser.parse(options, args);
			if (cmd.hasOption("h")) {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("sb server", options);
			}
			if (cmd.hasOption("v")) {
				log.log(Level.INFO, "Using cli argument -v=" + cmd.getOptionValue("v"));
				 prueba = Integer.parseInt( cmd.getOptionValue("port") );  
			} else {
				log.log(Level.SEVERE, "MIssing v option");
				help();
			}

		} catch (ParseException e) {
			log.log(Level.SEVERE, "Failed to parse comand line properties", e);
			help();
		}

	}

	private void help() {
		// This prints out some help
		HelpFormatter formater = new HelpFormatter();
		formater.printHelp("Main", options);
		System.exit(0);
	}

}
