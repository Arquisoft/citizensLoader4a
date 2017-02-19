package es.uniovi.asw.parser.adapter;

import es.uniovi.asw.parser.differentParsers.MyParser;

public class MyParserAdapter implements GeneralParser{
	MyParser parser;
	String[] args;
	
	public MyParserAdapter() {
		
	}
	@Override
	public void parse(String... args) {
		/*
		 * Como utiliza los mismos comandos que el parser original, no hacen falta converisones. De momento
		 */
		parser = new MyParser(args);
		parser.parse();		
	}

}
