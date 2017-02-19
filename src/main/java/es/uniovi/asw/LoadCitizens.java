package es.uniovi.asw;

import es.uniovi.asw.parser.adapter.GeneralParser;
import es.uniovi.asw.parser.adapter.MyParserAdapter;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadCitizens {

	public static void main(String... args) {
		final LoadCitizens runner = new LoadCitizens();

		runner.run(args);
	}

	// TODO
	private void run(String... args) {
		
		
		//Escoge el parser:
		//GeneralParser parser = new MyParserAdapter();
		GeneralParser parser = new MyParserAdapter();
		parser.parse(args);
	}
}
