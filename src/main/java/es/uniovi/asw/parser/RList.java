package es.uniovi.asw.parser;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Citizen;
/**
 * Crea los subcomponentes del parser necesarios para procesar el fichero de entrada.
 */
public class RList implements ReadList{

	@Override
	public List<Citizen> read(String path) {
		List<Citizen> ciudadanos = readFile(path);
		return ciudadanos;
	}

	private List<Citizen> readFile(String path) {
		XSSFWorkbook wb;
		XSSFSheet sheet;
		Iterator<Row> rows;
		Row row = null;
		Citizen ciudadano;
		
		try {
			wb = new XSSFWorkbook(new File(path));
			sheet = wb.getSheetAt(0);
			rows = sheet.iterator();
			
			rows.next();
			
			while (rows.hasNext()) {
				//Luego lo hago
			}
								
		} catch (InvalidFormatException e) {
			System.out.println("El fichero no es un .xlsx");
		} catch (Exception e) {
			String[] fileName = path.split("/");
			System.out.println("El fichero " + fileName[fileName.length - 1] + " no existe");
		}
		
		return null;
	}
}
