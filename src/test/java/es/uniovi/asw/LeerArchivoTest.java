package es.uniovi.asw;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.RListExcel;
import es.uniovi.asw.parser.RListTXT;
import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.util.CLLogger;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LeerArchivoTest {

	@Test
	public void leerExcel() {
		try {
			CLLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	}
	
	@Test
	public void leerExcelDiferenteEntrada() {
		try {
			CLLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public void leerConErrores() {
		String fileName = "testErrors.xlsx";
		List<Citizen> ciudadanos;
		ReadList rl = new RListExcel();
		ciudadanos = rl.read("src/test/resources/" + fileName);
		
		//Devuelve la lista siempre, aunque estén mal
		assertEquals(3, ciudadanos.size());
		
	}

	@Test
	public void leerConErroresEnParametrosDeEntrada() {
		String fileName = "testErrorsParametros.xlsx";
		List<Citizen> ciudadanos;
		ReadList rl = new RListExcel();
		ciudadanos = rl.read("src/test/resources/" + fileName);

		assertEquals(3, ciudadanos.size());
	}

	@Test
	public void leerTXT() throws ParseException {
		String fileName = "test.txt";
		List<Citizen> ciudadanos;
		ReadList rl = new RListTXT();
		ciudadanos = rl.read("src/test/resources/" + fileName);
		Citizen c1 = ciudadanos.get(0);


		//assertEquals(c1.equals(c2), false);
		assertEquals(ciudadanos.get(0).getApellidos(), "Torres Pardo");
		assertEquals(ciudadanos.get(0).getNombre(), "Juan");
		assertEquals(ciudadanos.get(0).getEmail(), "h@h.es");
		assertEquals(ciudadanos.get(0).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(0).getFechaNacimiento(), new SimpleDateFormat("dd/MM/yyyy").parse("10/12/1234"));
		assertEquals(ciudadanos.get(0).getNumeroIdentificativo(), "9876543S");


	}
/*
	@Test
	public void forzarExcepcionesExcel() {
		boolean thrown = false;
		// Leer un archivo con nombre null
		String fileName = null;
		List<Citizen> ciudadanos;
		ReadList rl = new RListExcel();
		// Leer un archivo con nombre null

		ciudadanos = rl.read("src/test/resources/" + fileName);

		if (ciudadanos.size() == 0)
			thrown = true;
		assertEquals(true, thrown);

		thrown = false;
		ciudadanos = null;

		// Formato incorrecto
		fileName = "test.txt";

		ciudadanos = rl.read("src/test/resources/" + fileName);
		if (ciudadanos.size() == 0)
			thrown = true;

		assertEquals(true, thrown);
	}
	@Test
	public void forzarExcepcionesPlainText() {
		boolean thrown = false;
		// Leer un archivo con nombre null
		String fileName = null;
		List<Citizen> ciudadanos;
		ReadList rl = new RListTXT();
		// Leer un archivo con nombre null
		ciudadanos = rl.read("src/test/resources/" + fileName);

		if (ciudadanos.size() == 0)
			thrown = true;
		assertEquals(true, thrown);

		thrown = false;
		ciudadanos = null;

		// Formato incorrecto
		fileName = "test.xls";

		ciudadanos = rl.read("src/test/resources/" + fileName);
		if (ciudadanos.size() == 0)
			thrown = true;

		assertEquals(true, thrown);
	}
	*/
	@Test
	public void camposNull(){
		try {
			CLLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Citizen> ciudadanos;
		ReadList rl = new RListExcel();
		ciudadanos = rl.read("src/test/resources/testCamposNull.xlsx");

		assertEquals("", ciudadanos.get(0).getEmail());
		assertEquals("Juan8", ciudadanos.get(0).getNombre());
		
		assertEquals(null, ciudadanos.get(3).getNombre());
		assertEquals(null, ciudadanos.get(4).getDireccionPostal());
	}
}
