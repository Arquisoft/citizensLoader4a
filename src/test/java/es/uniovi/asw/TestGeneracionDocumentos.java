package es.uniovi.asw;

import es.uniovi.asw.perosnalLetter.SingletonTextWritter;
import es.uniovi.asw.perosnalLetter.TextWritter;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TestGeneracionDocumentos {
	@Test
	public void generarPDFBasico() {
		TextWritter generadorPDF = SingletonTextWritter.getInstance().getPDFTextrWitter();
		generadorPDF.createDocument("PruebaPDF_Basico", "Esto es un pdf muy básico");
		File myFile = new File("src/test/resources/PruebaPDF_Basico.pdf");
		boolean existe = false;
		if (myFile.exists())
			existe = true;
		assertEquals(true, existe);
	}
	@Test
	public void generarPlainTextBasico(){
		TextWritter generadorPlainText = SingletonTextWritter.getInstance().getPlainTextWritter();
		generadorPlainText.createDocument("PruebaPlainText_Basico", "Esto es un txt muy básico");
		File myFile = new File("src/test/resources/PruebaPlainText_Basico.txt");
		boolean existe = false;
		if (myFile.exists())
			existe = true;
		assertEquals(true, existe);
	}
	@Test
	public void generarWordBasico(){
		TextWritter generadorWord = SingletonTextWritter.getInstance().getWordTextWritter();
		generadorWord.createDocument("PruebaWord_Basico", "Esto es un Wrod muy básico");
		File myFile = new File("src/test/resources/PruebaWord_Basico.docx");
		boolean existe = false;
		if (myFile.exists())
			existe = true;
		assertEquals(true, existe);
	}
}
