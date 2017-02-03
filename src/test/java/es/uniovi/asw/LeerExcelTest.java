package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.parser.RList;
import es.uniovi.asw.parser.ReadList;

public class LeerExcelTest {

	@Test
	public void leerExcel() {
		List<Citizen> ciudadanos;
		ReadList rl= new RList();
		ciudadanos = rl.read("src/test/resources/test.xlsx");
		
		assertEquals(ciudadanos.get(0).getSurname(), "Torres Pardo");
		assertEquals(ciudadanos.get(1).getSurname(), "López Fernando");
		assertEquals(ciudadanos.get(2).getSurname(), "Torres Pardo");
	}
}
