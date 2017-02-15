package es.uniovi.asw;

import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.util.Console;
import es.uniovi.asw.util.exception.CitizenException;

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
		try {
			new Parser(args).parse();
		} catch (CitizenException e) {
			Console.println(e.getMessage());
		}
	}
	}

