package es.uniovi.asw.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Citizen;

/**
 * Crea los subcomponentes del parser necesarios para procesar el fichero de
 * entrada.
 */
public class RList implements ReadList {

	@Override
	public List<Citizen> read(String path) {
		List<Citizen> ciudadanos = readFile(path);
		return ciudadanos;
	}

	private List<Citizen> readFile(String path) {
		XSSFWorkbook wb;
		XSSFSheet sheet;
		Iterator<Row> rowIterator;
		Row row = null;
		Citizen ciudadano;
		List<Citizen> ciudadanos = new ArrayList<Citizen>();

		try {
			wb = new XSSFWorkbook(new File(path));
			sheet = wb.getSheetAt(0);
			rowIterator = sheet.iterator();

			rowIterator.next();

			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				ciudadano = new Citizen();
				ciudadano.setName(row.getCell(0) != null ? row.getCell(0).getStringCellValue() : null);
				ciudadano.setSurname(row.getCell(1) != null ? row.getCell(1).getStringCellValue() : null);
				ciudadano.setEmail(row.getCell(2) != null ? row.getCell(2).getStringCellValue() : null);
				ciudadano.setBirthdate(row.getCell(3) != null ? row.getCell(3).getDateCellValue() : null);
				ciudadano.setAddress(row.getCell(4) != null ? row.getCell(4).getStringCellValue() : null);
				ciudadano.setNationality(row.getCell(5) != null ? row.getCell(5).getStringCellValue() : null);
				ciudadano.setNif(row.getCell(6) != null ? row.getCell(6).getStringCellValue() : null);
				

				// Crea un usuario y contraseña aleatorio
				String us=getCadenaAlfanumAleatoria(5);
				String con= getCadenaAlfanumAleatoria(4);
				ciudadano.setPassword(con);
				ciudadano.setUser(us);
				ciudadanos.add(ciudadano);
			}

		} catch (InvalidFormatException e) {
			System.out.println("El fichero no es un .xlsx");
		} catch (Exception e) {
			String[] fileName = path.split("/");
			System.out.println("El fichero " + fileName[fileName.length - 1] + " no existe");
		}

		return ciudadanos;
	}

	private String getCadenaAlfanumAleatoria(int longitud) {
		String cadenaAleatoria = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while (i < longitud) {
			char c = (char) r.nextInt(255);
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
				cadenaAleatoria += c;
				i++;
			}
		}
		return cadenaAleatoria;
	}
}
