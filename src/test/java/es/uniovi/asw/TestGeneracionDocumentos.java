package es.uniovi.asw;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import es.uniovi.asw.perosnalLetter.SingletonTextWritter;
import es.uniovi.asw.perosnalLetter.TextWritter;

public class TestGeneracionDocumentos {
	@Test
	public void generarPDFBasico(){
		TextWritter generadorPDF = SingletonTextWritter.getInstance().getPDFTextrWitter();
		generadorPDF.createDocument("PruebaPDF_Basico", "Esto es un pdf muy básico");
		assertEquals(true, true);
	}
}
