package es.uniovi.asw;

import es.uniovi.asw.parser.adapter.GeneralParser;
import es.uniovi.asw.parser.adapter.MyParserAdapter;
import es.uniovi.asw.util.exception.CitizenException;

import java.util.logging.Logger;


/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadCitizens {
	private static final Logger log = Logger.getLogger(LoadCitizens.class.getName());


	public static void main(String... args) {
		final LoadCitizens runner = new LoadCitizens();

		runner.run(args);
	}

	// TODO
	public int run(String... args) {
		
		
		//Escoge el parser:

		GeneralParser parser = new MyParserAdapter();
		//GeneralParser parser = new ApacheParserAdapter();
		//GeneralParser parser = new ParserDePrueberAdapter();

		try {
			parser.parse(args);
		} catch (CitizenException e) {
			log.info("Exit 1");
			return 1;
		}
		log.info("Exit 0");
		return 0;
	}
}
