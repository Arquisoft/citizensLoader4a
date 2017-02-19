package es.uniovi.asw.parser.differentParsers;

import es.uniovi.asw.util.Console;

/**
 * A probar cosas
 * @author Javier Castro
 *
 */
public class ParserDePrueber {
	public ParserDePrueber() {
		// TODO Auto-generated constructor stub
	}

	public void parse(String... args) {
		Console.print("\n------------ PARSER DE PRUEBER! -------------\n");
		for (String s : args) {
			Console.println("\tHe leido: " + s);
		}

	}
}
