package es.uniovi.asw.letters;

import es.uniovi.asw.model.Citizen;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class PlainTextLetter {
	private FileWriter writer;

	public PlainTextLetter() {
	}

	public void WriteLetter(Citizen ciudadano)  {

		try {
			setWriter(new FileWriter( "src/main/resources/letters/" +ciudadano.getNumero_identificativo() + ".txt"));
			getWriter().write("Dear :" + "\t" + ciudadano.getNombre() + "\n");
			getWriter().write("User :" + "\t" + ciudadano.getEmail() + "\n");
			getWriter().write("Password :" + "\t" + ciudadano.getContrasena() + "\n");
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
