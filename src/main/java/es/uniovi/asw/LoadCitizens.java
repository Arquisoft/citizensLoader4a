package es.uniovi.asw;
import es.uniovi.asw.parser.Parser;

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
			new Parser(args).parse();
	}
	}

