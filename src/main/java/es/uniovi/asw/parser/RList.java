package es.uniovi.asw.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import es.uniovi.asw.util.Comprobador;
import es.uniovi.asw.util.Console;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.reportWritter.WreportP;

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

		StringBuilder logger = new StringBuilder();

		try {
			wb = new XSSFWorkbook(new File(path));
			sheet = wb.getSheetAt(0);
			rowIterator = sheet.iterator();

			rowIterator.next();

			String name;
			String surname;
			String email;
			Date birth;
			String address;
			String nationality;
			String nif;

			boolean nameResult;
			boolean surnameResult;
			boolean emailResult;
			boolean birthResult;
			boolean addressResult;
			boolean nationalityResult;
			boolean nifResult;

			int actualrow = 0;
			while (rowIterator.hasNext()) {
				actualrow++;
				row = rowIterator.next();
				name = row.getCell(0) != null ? row.getCell(0).getStringCellValue() : null;
				nameResult = Comprobador.esTodoTexto(name);
				surname = row.getCell(1) != null ? row.getCell(1).getStringCellValue() : null;
				surnameResult = Comprobador.esTodoTexto(surname);
				email = row.getCell(2) != null ? row.getCell(2).getStringCellValue() : null;
				emailResult = Comprobador.esEmailCorrecto(email);
				// birthResult =
				// Comprobador.fechaCorrecta(row.getCell(3).getStringCellValue());
				// // Orden
				// importante
				birthResult = true;
				birth = row.getCell(3) != null && birthResult ? row.getCell(3).getDateCellValue() : null;
				address = row.getCell(4) != null ? row.getCell(4).getStringCellValue() : null;
				// addressResult = Comprobador.esTodoTexto(address);
				addressResult = true;
				nationality = row.getCell(5) != null ? row.getCell(5).getStringCellValue() : null;
				nationalityResult = Comprobador.esTodoTexto(nationality);
				nif = row.getCell(6) != null ? row.getCell(6).getStringCellValue() : null;
				nifResult = nif != null ? true : false;

				// Se carga mas info al logger.
				boolean todoOK = completeTextForLog(logger, nameResult, surnameResult, emailResult, birthResult,
						addressResult, nationalityResult, nifResult, actualrow);

				if (todoOK) {
					ciudadano = new Citizen();
					ciudadano.setName(name);
					ciudadano.setSurname(surname);
					ciudadano.setEmail(email);
					ciudadano.setBirthdate(birth);
					ciudadano.setAddress(address);
					ciudadano.setNationality(nationality);
					ciudadano.setNif(nif);

					// Crea un usuario y contraseña aleatorio
					String us = getCadenaAlfanumAleatoria(5);
					String con = getCadenaAlfanumAleatoria(4);
					ciudadano.setPassword(con);
					ciudadano.setUser(us);
					ciudadanos.add(ciudadano);
				}

			}

		} catch (InvalidFormatException e) {
			Console.print("El fichero no es un .xlsx");
		} catch (Exception e) {
			String[] fileName = path.split("/");
			Console.print("El fichero " + fileName[fileName.length - 1] + " no existe");
		}

		// Crear el fichero log
		String[] cachos = path.split("/");
		String nombreFich1 = cachos[cachos.length - 1];
		String nombreFich = nombreFich1.replace(".xlsx", "");

		WreportP reporter = new WreportP(nombreFich, logger.toString());
		reporter.createErrorLogFile();
		//
		return ciudadanos;
	}

	/**
	 * Crea la cadena aleatoria de caracteres para generar la contraseña
	 * @param longitud
	 * @return
	 */
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

	private boolean completeTextForLog(StringBuilder actualLoggingText, boolean name, boolean surname, boolean email,
			boolean birth, boolean address, boolean nationality, boolean nif, int actualrow) {

		boolean todoOK = true;
		actualLoggingText.append("Ciudadano líena -> " + actualrow + "\n");
		if (!name) {
			actualLoggingText.append("\t" + ErrorTypes.NAME_ERROR + " column " + 0 + "\n");
			todoOK = false;
		}
		if (!surname) {
			actualLoggingText.append("\t" + ErrorTypes.SURNAME_ERROR + " column " + 1 + "\n");
			todoOK = false;
		}
		if (!email) {
			actualLoggingText.append("\t" + ErrorTypes.EMAIL_ERROR + " column " + 2 + "\n");
			todoOK = false;
		}
		if (!address) {
			actualLoggingText.append("\t" + ErrorTypes.ADDRESS_ERROR + " column " + 4 + "\n");
			todoOK = false;
		}
		if (!birth) {
			actualLoggingText.append("\t" + ErrorTypes.DATE_ERROR + " column " + 3 + "\n");
			todoOK = false;
		}
		if (!nationality) {
			actualLoggingText.append("\t" + ErrorTypes.NATIONALITY_ERROR + " column " + 5 + "\n");
			todoOK = false;
		}
		if (!nif) {
			actualLoggingText.append("\t" + ErrorTypes.NIF_ERROR + "column " + 6 + "\n");
			todoOK = false;
		}
		if (!todoOK) {
			actualLoggingText.append("\tCiudadano no creado, por favor, arregle los errores.");
		} else {
			actualLoggingText.append("\t" + ErrorTypes.OK);
		}
		actualLoggingText.append("\n");
		return todoOK;
	}

}
