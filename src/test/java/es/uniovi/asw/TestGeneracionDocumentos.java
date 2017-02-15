package es.uniovi.asw;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.personalletter.MensajePersonalizado;
import es.uniovi.asw.personalletter.SingletonTextWritter;
import es.uniovi.asw.personalletter.TextWritter;
import es.uniovi.asw.util.Exception.CitizenException;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestGeneracionDocumentos {
	Citizen paco;



	@Before
	public void creemosAPaco() {
		paco = new Citizen();
		paco.setNombre("Paco");
		paco.setApellidos("Álvarez García");
		paco.setEmail("paqueras@correo.com");
		paco.setContrasena("pacoPAQUETE69");
		paco.setDireccionPostal("La calle de Paco, 9, 3H");
		paco.setFecha_nacimiento(new Date());
		paco.setNacionalidad("España");
		paco.setNumero_identificativo("569874565g");
	}

	@Test
	public void generarPDFBasico() throws CitizenException {
		TextWritter generadorPDF = SingletonTextWritter.getInstance().getPDFTextrWitter();
		generadorPDF.createDocument("PruebaPDF_Basico", "Esto es un pdf muy básico");
		File myFile = new File("src/test/resources/PruebaPDF_Basico.pdf");
		boolean existe = false;
		if (myFile.exists())
			existe = true;
		assertEquals(true, existe);
	}

	@Test
	public void generarPlainTextBasico() throws CitizenException {
		TextWritter generadorPlainText = SingletonTextWritter.getInstance().getPlainTextWritter();
		generadorPlainText.createDocument("PruebaPlainText_Basico", "Esto es un txt muy básico");
		File myFile = new File("src/test/resources/PruebaPlainText_Basico.txt");
		boolean existe = false;
		if (myFile.exists())
			existe = true;
		assertEquals(true, existe);
	}

	@Test
	public void generarWordBasico() throws CitizenException {
		TextWritter generadorWord = SingletonTextWritter.getInstance().getWordTextWritter();
		generadorWord.createDocument("PruebaWord_Basico", "Esto es un Wrod muy básico");
		File myFile = new File("src/test/resources/PruebaWord_Basico.docx");
		boolean existe = false;
		if (myFile.exists())
			existe = true;
		assertEquals(true, existe);
	}

	@Test
	public void generarPDFConPaco() throws CitizenException {

		String mensaje = MensajePersonalizado.getMessage(paco);
		TextWritter generadorPDF = SingletonTextWritter.getInstance().getPDFTextrWitter();
		generadorPDF.createDocument("PruebaPDF_PACO", mensaje);

		// Existe?
		File myFile = new File("src/test/resources/PruebaPDF_PACO.pdf");
		boolean existe = false;
		if (myFile.exists())
			existe = true;
		assertEquals(true, existe);

	}

	@Test
	public void generarTXTConPaco() throws CitizenException {

		String mensaje = MensajePersonalizado.getMessage(paco);
		TextWritter generadorTXT = SingletonTextWritter.getInstance().getPlainTextWritter();
		generadorTXT.createDocument("PruebaTXT_PACO", mensaje);

		// Existe?
		File myFile = new File("src/test/resources/PruebaTXT_PACO.txt");
		boolean existe = false;
		if (myFile.exists())
			existe = true;
		assertEquals(true, existe);

		StringBuilder contenidoTXT = new StringBuilder();
		FileReader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(myFile);
			br = new BufferedReader(reader);
			String cadena = "";
			while ((cadena = br.readLine()) != null) {
				contenidoTXT.append(cadena);
			}
			
		} catch (FileNotFoundException e) {
			assertEquals(true, false); // Para que casque
		} catch (IOException e) {
			assertEquals(true, false); // Para que casque
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				assertEquals(true, false); // Para que casque
			}
		}
//		mensaje.replace("\n", "");
//		mensaje.replace("\t", "");
//		Console.println(mensaje);
//		Console.println(contenidoTXT);
		assertEquals(true, contenidoTXT.toString().contains("Paco") && contenidoTXT.toString().contains("paqueras@correo.com"));
	}
}
