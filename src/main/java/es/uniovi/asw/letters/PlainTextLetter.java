package es.uniovi.asw.letters;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import es.uniovi.asw.model.Citizen;

public class PlainTextLetter {
	private FileWriter writer;

	public PlainTextLetter() {
	}

	public void WriteLetter(Citizen ciudadano)  {

		try {
			setWriter(new FileWriter( "src/main/resources/letters/" +ciudadano.getNif() + ".txt"));
			getWriter().write("Dear :" + "\t" + ciudadano.getName() + "\n");
			getWriter().write("User :" + "\t" + ciudadano.getEmail() + "\n");
			getWriter().write("Password :" + "\t" + ciudadano.getPassword() + "\n");
			getWriter().write(new Date().toString());
			getWriter().close();
		} catch (IOException e) {
			System.err.println("No se ha podido crear el archivo" + e.getMessage());
		}

	}

	public FileWriter getWriter() {
		return writer;
	}

	public void setWriter(FileWriter writer) {
		this.writer = writer;
	}

}
