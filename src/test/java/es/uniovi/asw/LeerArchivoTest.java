package es.uniovi.asw;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.RListExcel;
import es.uniovi.asw.parser.RListTXT;
import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.util.CLLogger;
import org.junit.Test;

import java.io.IOException;
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
		assertEquals(ciudadanos.get(2).getNumero_identificativo(), "09940449X");
		assertEquals(ciudadanos.get(2).getDireccion_postal(), "Av. De la Constitución 8");




	}

	@Test
	public void leerConErrores() {
		String fileName = "testErrors.xlsx";
		List<Citizen> ciudadanos;
		ReadList rl = new RListExcel();
		ciudadanos = rl.read("src/test/resources/" + fileName);
		
		assertEquals(0,	ciudadanos.size());
	}
	
	@Test
	public void leerTXT() {
		String fileName = "test.txt";
		List<Citizen> ciudadanos;
		ReadList rl = new RListTXT();
		ciudadanos = rl.read("src/test/resources/" + fileName);

		assertEquals(ciudadanos.get(0).getApellidos(), "Torres Pardo");
		assertEquals(ciudadanos.get(0).getNombre(), "Juan");
		assertEquals(ciudadanos.get(0).getEmail(), "j@h.es");
		assertEquals(ciudadanos.get(0).getNacionalidad(), "Español");
		assertEquals(ciudadanos.get(0).getNumero_identificativo(), "9876543S");
		assertEquals(ciudadanos.size(), 1);
		}
}
