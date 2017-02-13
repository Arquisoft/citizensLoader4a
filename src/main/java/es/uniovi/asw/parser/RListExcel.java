package es.uniovi.asw.parser;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.reportwritter.GenerateLogText;
import es.uniovi.asw.util.Comprobador;
import es.uniovi.asw.util.Console;

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
	public final static String CELDA_NOMBRE = "No";
	public final static String CELDA_APELLIDOS = "Ap";
	public final static String CELDA_EMAIL = "Em";
	public final static String CELDA_CORREO = "Cor";
	public final static String CELDA_FECHA = "Fec";
	public final static String CELDA_DIRECCION = "Dir";
	public final static String CELDA_NACIONALIDAD = "Nac";
	public final static String CELDA_DNI = "DNI";
	public final static String CELDA_NIF = "nif";

	private String[] listadoColumnas = { CELDA_APELLIDOS, CELDA_CORREO, CELDA_DIRECCION, CELDA_DNI, CELDA_EMAIL,
			CELDA_FECHA, CELDA_NACIONALIDAD, CELDA_NIF, CELDA_NOMBRE };

	@Override
	public List<Citizen> readFile(String path) {

		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		Iterator<Row> rowIterator = null;
		Row row = null;
		List<Citizen> ciudadanos = new ArrayList<Citizen>();

		String name, surname, email;
		Date birth;
		String address;
		String nationality;
		String nif;

		int colNombre = 0, colApellido = 0, colEmail = 0, colBirth = 0, colAddress = 0, colNacionalidad = 0, colNif = 0;
		
		try {
			wb = new XSSFWorkbook(new File(path));
			sheet = wb.getSheetAt(0);
			rowIterator = sheet.iterator();
			int columna = 0;
			row = rowIterator.next();
			while (columna < 7) {
				String celda = row.getCell(columna).getStringCellValue();
				// if (celda.startsWith(CELDA_NOMBRE))
				// colNombre = columna;
				// else if (celda.startsWith(CELDA_APELLIDOS))
				// colApellido = columna;
				// else if (celda.startsWith(CELDA_CORREO)
				// || celda.startsWith(CELDA_EMAIL))
				// colEmail = columna;
				// else if (celda.startsWith(CELDA_FECHA))
				// colBirth = columna;
				// else if (celda.startsWith(CELDA_DIRECCION))
				// colAddress = columna;
				// else if (celda.startsWith(CELDA_NACIONALIDAD))
				// colNacionalidad = columna;
				// else if (celda.startsWith(CELDA_DNI)
				// || celda.startsWith(CELDA_NIF))
				// colNif = columna;

				colNombre = getOrdenColumna(columna, celda);
				colApellido = getOrdenColumna(columna, celda);
				colEmail = getOrdenColumna(columna, celda);
				colBirth = getOrdenColumna(columna, celda);
				colAddress = getOrdenColumna(columna, celda);
				colNacionalidad = getOrdenColumna(columna, celda);
				colNif = getOrdenColumna(columna, celda);
				columna++;
			}

			int actualrow = 0;
			while (rowIterator.hasNext()) {
				actualrow++;
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

		} catch (InvalidFormatException e) {
			Console.print("El fichero no es un .xlsx");
		} catch (Exception e) {
			String[] fileName = path.split("/");
			Console.print("El fichero " + fileName[fileName.length - 1] + " no existe");
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

	private int getOrdenColumna(int columnaActual, String celda) {
		for (String type : listadoColumnas) {
			if (celda.startsWith(type)) {
				return columnaActual;
			}
		}
		return -1;
	}

}
