package es.uniovi.asw.parser.adapter;

import es.uniovi.asw.parser.differentParsers.MyParser;
import es.uniovi.asw.util.Console;
import es.uniovi.asw.util.exception.CitizenException;

public class MyParserAdapter implements GeneralParser {
	MyParser parser;

	public MyParserAdapter() {

	}

	@Override
	public void parse(String... args) throws CitizenException {
		/*
		 * Como utiliza los mismos comandos que el parser original, no hacen
		 * falta converisones. De momento
		 */
		for (Object s : args) {
			Console.println(s.toString() + " ");
		}
		parser = new MyParser(args);
		parser.parse();
	}

}
