package es.uniovi.asw.parser.adapter;

import es.uniovi.asw.parser.differentParsers.ApacheParser;
import es.uniovi.asw.util.Console;

public class ApacheParserAdapter{/* implements GeneralParser {
	ApacheParser parser;
	String[] args;



	@Override
	public void parse(String... args) {
		this.args = args;
		String[] mod = args[0].split(" ");
		for (int i = 0; i < mod.length; i++) {
			// Hay que ir añadiendo todas las opciones que tenga el de apache
			if (mod[i].equals("readExcel"))
				mod[i] = "-" + ApacheParser.READ_EXCEL_KEY;
			if (mod[i].equals("readTxt"))
				mod[i] = "-" + ApacheParser.READ_TXT_KEY;
		}
		String argsR = arrayToString(mod);
		String[] newArgs = { argsR, "" };
		Console.println("\n\n"+ newArgs[0]);
		parser = new ApacheParser(newArgs);
		parser.parse();
	}

	private String arrayToString(String[] c) {
		StringBuilder sb = new StringBuilder();
		for (String s : c) {
			sb.append(s + " ");
		}
		return sb.toString();
	}*/
}
