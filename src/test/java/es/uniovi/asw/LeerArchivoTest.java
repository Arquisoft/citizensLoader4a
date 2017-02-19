package es.uniovi.asw;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.RListExcel;
import es.uniovi.asw.parser.RListTXT;
import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.util.Comprobador;
import es.uniovi.asw.util.exception.CitizenException;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

public class LeerArchivoTest {

	@Test
	public void leerExcel() throws CitizenException {
		List<Citizen> ciudadanos;
		ReadList rl = new RListExcel();
		ciudadanos = rl.read("src/test/resources/test.xlsx");

		assertEquals(ciudadanos.get(0).getApellidos(), "Torres Pardo");
		assertEquals(ciudadanos.get(1).getApellidos(), "López Fernando");
		assertEquals(ciudadanos.get(2).getApellidos(), "Torres Pardo");

		assertEquals(ciudadanos.get(0).getNombre(), "Juan");
		assertEquals(ciudadanos.get(1).getNombre(), "Luis");
		assertEquals(ciudadanos.get(2).getNombre(), "Ana");

		assertEquals(ciudadanos.get(2).getEmail(), "ana@example.com");
		assertEquals(ciudadanos.get(2).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(1).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(0).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(2).getNumeroIdentificativo(), "09940449X");
		assertEquals(ciudadanos.get(2).getDireccionPostal(), "Av. De la Constitución 8");

		// Hace lo mismo pero con otros nombres de las columnas
		ciudadanos = rl.read("src/test/resources/testColumnasOtroNombre.xlsx");

		assertEquals(ciudadanos.get(0).getApellidos(), "Torres Pardo");
		assertEquals(ciudadanos.get(1).getApellidos(), "López Fernando");
		assertEquals(ciudadanos.get(2).getApellidos(), "Torres Pardo");

		assertEquals(ciudadanos.get(0).getNombre(), "Juan");
		assertEquals(ciudadanos.get(1).getNombre(), "Luis");
		assertEquals(ciudadanos.get(2).getNombre(), "Ana");

		assertEquals(ciudadanos.get(2).getEmail(), "ana@example.com");
		assertEquals(ciudadanos.get(2).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(1).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(0).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(2).getNumeroIdentificativo(), "09940449X");
		assertEquals(ciudadanos.get(2).getDireccionPostal(), "Av. De la Constitución 8");
	}

	@Test
	public void testEqualsCitizen() {
		Citizen c = new Citizen();
		Citizen b = c;
		assertTrue(b.equals(c));
		c.setNumeroIdentificativo("3553");
		b = new Citizen();
		b.setNumeroIdentificativo("56");
		assertFalse(b.equals(c));
	}

	@Test
	public void testHashCode() {
		Citizen c = new Citizen();
		c.setNumeroIdentificativo("3553");
		int hash = c.hashCode();
		assertEquals(hash, c.hashCode());
	}

	@Test
	public void leerExcelDiferenteEntrada() throws CitizenException {

		List<Citizen> ciudadanos;
		ReadList rl = new RListExcel();
		ciudadanos = rl.read("src/test/resources/testDesorden.xlsx");

		assertEquals(ciudadanos.get(0).getApellidos(), "Torres Pardo");
		assertEquals(ciudadanos.get(1).getApellidos(), "López Fernando");
		assertEquals(ciudadanos.get(2).getApellidos(), "Torres Pardo");

		assertEquals(ciudadanos.get(0).getNombre(), "Juan");
		assertEquals(ciudadanos.get(1).getNombre(), "Luis");
		assertEquals(ciudadanos.get(2).getNombre(), "Ana");

		assertEquals(ciudadanos.get(2).getEmail(), "ana@example.com");
		assertEquals(ciudadanos.get(2).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(1).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(0).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(2).getNumeroIdentificativo(), "09940449X");
		assertEquals(ciudadanos.get(2).getDireccionPostal(), "Av. De la Constitución 8");

		ciudadanos = rl.read("src/test/resources/testDesorden2.xlsx");

		assertEquals(ciudadanos.get(0).getApellidos(), "Torres Pardo");
		assertEquals(ciudadanos.get(1).getApellidos(), "López Fernando");
		assertEquals(ciudadanos.get(2).getApellidos(), "Torres Pardo");

		assertEquals(ciudadanos.get(0).getNombre(), "Juan");
		assertEquals(ciudadanos.get(1).getNombre(), "Luis");
		assertEquals(ciudadanos.get(2).getNombre(), "Ana");

		assertEquals(ciudadanos.get(2).getEmail(), "ana@example.com");
		assertEquals(ciudadanos.get(2).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(1).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(0).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(2).getNumeroIdentificativo(), "09940449X");
		assertEquals(ciudadanos.get(2).getDireccionPostal(), "Av. De la Constitución 8");
	}

	@Test
	public void leerConErrores() throws CitizenException {
		String fileName = "testErrors.xlsx";
		List<Citizen> ciudadanos;
		ReadList rl = new RListExcel();
		ciudadanos = rl.read("src/test/resources/" + fileName);

		// Devuelve la lista siempre, aunque estén mal
		assertEquals(3, ciudadanos.size());

	}

	@Test
	public void leerConErroresEnParametrosDeEntrada() throws CitizenException {
		String fileName = "testErrorsParametros.xlsx";
		List<Citizen> ciudadanos;
		ReadList rl = new RListExcel();
		ciudadanos = rl.read("src/test/resources/" + fileName);

		assertEquals(3, ciudadanos.size());
	}

	@Test
	public void leerTXT() throws ParseException, CitizenException {
		String fileName = "test.txt";
		List<Citizen> ciudadanos;
		ReadList rl = new RListTXT();
		ciudadanos = rl.read("src/test/resources/" + fileName);

		// assertEquals(c1.equals(c2), false);
		assertEquals(ciudadanos.get(0).getApellidos(), "Torres Pardo");
		assertEquals(ciudadanos.get(0).getNombre(), "Juan");
		assertEquals(ciudadanos.get(0).getEmail(), "h@h.es");
		// assertEquals(ciudadanos.get(0).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(0).getFechaNacimiento(), new SimpleDateFormat("dd/MM/yyyy").parse("10/12/1234"));
		assertEquals(ciudadanos.get(0).getNumeroIdentificativo(), "9876543S");

	}

	@Test(expected = CitizenException.class)
	public void forzarExcepcionesExcel() throws CitizenException {
		String fileName = "";
		ReadList rl = new RListExcel();

		// Leer un archivo con nombre null
		fileName = null;
		rl.read("src/test/resources/" + fileName);

	}

	@Test(expected = CitizenException.class)
	public void forzarExcepcionesExcelDirectorio() throws CitizenException {

		ReadList rl = new RListExcel();
		rl.read("src/test/resources"); // Le paso un directorio, que hara? Pues
										// peta

	}

	@Test(expected = CitizenException.class)
	public void forzarExcepcionesExcelFormat() throws CitizenException {
		String fileName = "";
		ReadList rl = new RListExcel();

		fileName = "test.txt";
		rl.read("src/test/resources/" + fileName);

	}

	@Test(expected = CitizenException.class)
	public void forzarExcepcionesFormatoIncorrectoExcel() throws CitizenException {
		// Formato incorrecto
		String fileName = "test.txt";
		ReadList rl = new RListExcel();
		rl.read("src/test/resources/" + fileName);

	}

	@Test(expected = CitizenException.class)
	public void forzarExcepcionesPlainText() throws CitizenException {

		// Leer un archivo con nombre null
		String fileName = null;
		ReadList rl = new RListTXT();
		// Leer un archivo con nombre null
		rl.read("src/test/resources/" + fileName);

	}

	@Test(expected = CitizenException.class)
	public void forzarExcepcionesFormatoIncorrectoTXT() throws CitizenException {
		// Formato incorrecto
		String fileName = "test.xlsx";
		ReadList rl = new RListTXT();
		rl.read("src/test/resources/" + fileName);

	}

	@Test
	public void camposNull() throws CitizenException {

		List<Citizen> ciudadanos;
		ReadList rl = new RListExcel();
		ciudadanos = rl.read("src/test/resources/testCamposNull.xlsx");

		assertEquals("", ciudadanos.get(0).getEmail());
		assertEquals("Juan8", ciudadanos.get(0).getNombre());

		assertEquals(null, ciudadanos.get(3).getNombre());
		assertEquals(null, ciudadanos.get(4).getDireccionPostal());
	}

	@Test
	public void vacios() throws CitizenException {

		List<Citizen> ciudadanos;
		ReadList rl = new RListExcel();
		ciudadanos = rl.read("src/test/resources/testVacios.xlsx");

		assertEquals(true, ciudadanos.size() == 0);

		rl = new RListTXT();
		ciudadanos = rl.read("src/test/resources/testVacio.txt");
		assertEquals(true, ciudadanos.size() == 0);

	}

	@Test(expected = CitizenException.class)
	public void testException() throws CitizenException {

		throw new CitizenException();
	}

	@Test(expected = CitizenException.class)
	public void testException2() throws CitizenException {

		throw new CitizenException(new Exception());
	}

	@Test(expected = CitizenException.class)
	public void testException3() throws CitizenException {

		throw new CitizenException("Lanzamiento de prueba", new Exception());
	}

	@Test
	public void testComprobadorDigitos() throws CitizenException {

		assertFalse(Comprobador.esTodoDigitos(""));
		assertFalse(Comprobador.esTodoDigitos("242424a2424"));
		assertTrue(Comprobador.esTodoDigitos("938958358"));

	}

	@Test
	public void testComprobadorEmail() throws CitizenException {

		assertFalse(Comprobador.esEmailCorrecto(""));
		assertFalse(Comprobador.esEmailCorrecto("@"));
		assertTrue(Comprobador.esEmailCorrecto("pela@gmail.com"));
	}

	@Test
	public void testComprobadorAddress() throws CitizenException {

		assertFalse(Comprobador.esAddressCorrecto(""));
		assertFalse(Comprobador.esAddressCorrecto("hola"));
		assertTrue(Comprobador.esAddressCorrecto("calle leon"));
	}

	@Test
	public void testComprobadorFecha() throws CitizenException {

		assertTrue(Comprobador.esFecha("12/09/1994"));

	}
	
	@Test(expected = CitizenException.class)
	public void forzarExcepcionesExcelFechaNacimiento() throws CitizenException {
		String fileName = "testFechaNacimientoErronea.xlsx";
		ReadList rl = new RListExcel();
		rl.read("src/test/resources/" + fileName);
	}
	/*
	@Test(expected = CitizenException.class)
	public void forzarExcepcionesTXTFechaNacimiento() throws CitizenException {
		String fileName = "testFechaNacimientoErronea.txt";
		ReadList rl = new RListTXT();
		rl.read("src/test/resources/" + fileName);
	}*/

}
