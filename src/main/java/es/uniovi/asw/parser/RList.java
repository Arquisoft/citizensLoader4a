package es.uniovi.asw.parser;

import java.io.File;
import java.util.ArrayList;
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
				ciudadano=new Citizen();
				ciudadano.setBirthdate(row.getCell(0) != null ? row.getCell(0).getDateCellValue() : null);
				ciudadano.setAddress(row.getCell(1) != null ? row.getCell(1).getStringCellValue() : null);
				ciudadano.setNationality(row.getCell(2) != null ? row.getCell(2).getStringCellValue() : null);
				ciudadano.setNif(row.getCell(3) != null ? row.getCell(3).getStringCellValue() : null);
				ciudadanos.add(ciudadano);
				//Luego lo hago
			}
								
		} catch (InvalidFormatException e) {
			System.out.println("El fichero no es un .xlsx");
		} catch (Exception e) {
			String[] fileName = path.split("/");
			System.out.println("El fichero " + fileName[fileName.length - 1] + " no existe");
		}
		
		return ciudadanos;
	}
}