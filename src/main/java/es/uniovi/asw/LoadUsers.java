package es.uniovi.asw;
import es.uniovi.asw.parser.Parser;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();

		runner.run(args);
	}

	// TODO
	private void run(String... args) {
			new Parser(args).parse();
	}
	}

