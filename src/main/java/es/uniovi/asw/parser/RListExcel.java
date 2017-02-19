package es.uniovi.asw.parser;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.util.Console;
import es.uniovi.asw.util.exception.CitizenException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RListExcel extends RList implements ReadList {


	@Override
	public List<Citizen> readFile(String path) throws CitizenException {

		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		Iterator<Row> rowIterator = null;
		Row row = null;
		List<Citizen> ciudadanos = new ArrayList<Citizen>();

		String name;
		String surname;
		String email;
		Date birth;
		String address, nationality,nif;

		int colNombre = 0;
		int colApellido = 0;
		int colEmail = 0;
		int colBirth = 0;
		int colAddress = 0;
		int colNacionalidad = 0;
		int colNif = 0;


		try {
			wb = new XSSFWorkbook(new File(path));
			sheet = wb.getSheetAt(0);
			rowIterator = sheet.iterator();
			int columna = 0;
			row = rowIterator.next();
			while (columna < 7) {
				String celda = row.getCell(columna).getStringCellValue();
				if (celda.startsWith("No"))
					colNombre = columna;
				else if (celda.startsWith("Ap"))
					colApellido = columna;
				else if (celda.startsWith("Cor") || celda.startsWith("Em"))
					colEmail = columna;
				else if (celda.startsWith("Fec"))
					colBirth = columna;
				else if (celda.startsWith("Dir"))
					colAddress = columna;
				else if (celda.startsWith("Nac"))
					colNacionalidad = columna;
				else if (celda.startsWith("DNI") || celda.startsWith("NIF"))
					colNif = columna;
				columna++;
			}

			while (rowIterator.hasNext()) {

				row = rowIterator.next();
				name = row.getCell(colNombre) != null ? row.getCell(colNombre).getStringCellValue() : null;
				surname = row.getCell(colApellido) != null ? row.getCell(colApellido).getStringCellValue() : null;

				email = row.getCell(colEmail) != null ? row.getCell(colEmail).getStringCellValue() : null;

				birth = row.getCell(colBirth) != null ? row.getCell(colBirth).getDateCellValue() : null;
				address = row.getCell(colAddress) != null ? row.getCell(colAddress).getStringCellValue() : null;

				nationality = row.getCell(colNacionalidad) != null ? row.getCell(colNacionalidad).getStringCellValue()
						: null;

				nif = row.getCell(colNif) != null ? row.getCell(colNif).getStringCellValue() : null;

				ciudadanos.add(anadirCitizen(name, surname, email, birth, address, nationality, nif));

			}
		} catch (org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException e) {
			throw  new CitizenException("Error en el formato del fichero");


		} /*catch (InvalidFormatException e) {
			Console.print("El fichero no es un .xlsx");
			throw  new CitizenException();

		}*/ catch (Exception e) {
			String[] fileName = path.split("/");
			Console.print(
					"Ha ocurrido un error. Asegurate de que el fichero existe y que la fecha de nacimiento está puesta en el formato correcto\n");
			throw  new CitizenException();

		} finally {

			try {
				if (wb != null) {
					wb.close();
				}
			} catch (IOException e) {

			}

		}
		/*
		 * // Crear el fichero log String[] cachos = path.split("/"); String
		 * nombreFich1 = cachos[cachos.length - 1]; String nombreFich =
		 * nombreFich1.replace(".xlsx", "");
		 * 
		 * WreportP reporter = new WreportP(nombreFich, logger.toString());
		 * reporter.createErrorLogFile(); //
		 */
		return ciudadanos;
	}

}
