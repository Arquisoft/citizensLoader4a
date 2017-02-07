package es.uniovi.asw.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import es.uniovi.asw.reportWritter.GenerateLogText;
import es.uniovi.asw.reportWritter.WreportP;

/**
 * Crea los subcomponentes del parser necesarios para procesar el fichero de
 * entrada.
 */
public class RList implements ReadList {

	@Override
	public List<Citizen> readExcel(String path) {
		List<Citizen> ciudadanos = readFileExcel(path);
		return ciudadanos;
	}

	private List<Citizen> readFileExcel(String path) {
		XSSFWorkbook wb;
		XSSFSheet sheet;
		Iterator<Row> rowIterator;
		Row row = null;
		List<Citizen> ciudadanos = new ArrayList<Citizen>();

		String name, surname, email;
		Date birth;
		String address;
		String nationality;
		String nif;

		boolean nameResult, surnameResult, emailResult, birthResult, addressResult, nationalityResult, nifResult;

		StringBuilder logger = new StringBuilder();

		try {
			wb = new XSSFWorkbook(new File(path));
			sheet = wb.getSheetAt(0);
			rowIterator = sheet.iterator();

			rowIterator.next();

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
				boolean todoOK = GenerateLogText.completeTextForLog(logger, nameResult, surnameResult, emailResult,
						birthResult, addressResult, nationalityResult, nifResult, actualrow);

				if (todoOK) {
					ciudadanos.add(anadirCitizen(name, surname, email, birth, address, nationality, nif));
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
	 * 
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

	@Override
	public List<Citizen> readTXT(String path) {

		List<Citizen> ciudadanos = new ArrayList<Citizen>();

		String name = "", surname, email, birth = "", address, nationality, nif;
		int row = 0;
		StringBuilder logger = new StringBuilder();

		boolean nameResult, surnameResult, emailResult, birthResult=true, addressResult=true, nationalityResult, nifResult=true;
		String cadena;

		try {
			FileReader f = new FileReader(path);
			BufferedReader b = new BufferedReader(f);

			while ((cadena = b.readLine()) != null) {
				row++;
				String[] datos = cadena.split(";");
				if (datos.length != 7)
					throw new Exception("No están todos los datos en el txt");// comprobar
				name = datos[0];
				nameResult = Comprobador.esTodoTexto(name);
				surname = datos[1];
				surnameResult = Comprobador.esTodoTexto(name);
				email = datos[2];
				emailResult = Comprobador.esEmailCorrecto(email);
				// birth=Date(datos[3]);
				address = datos[4];
				nationality = datos[5];
				nationalityResult = Comprobador.esTodoTexto(nationality);
				nif = datos[6];
				nifResult = nif != null ? true : false;
				boolean todoOK = GenerateLogText.completeTextForLog(logger, nameResult, surnameResult, emailResult,
						birthResult, addressResult, nationalityResult, nifResult, row);
				if (todoOK) {
					ciudadanos.add(anadirCitizen(name, surname, email, new SimpleDateFormat("dd/MM/yyyy").parse(birth),
							address, nationality, nif));
				}
			}
			b.close();
		} catch (ParseException e) {
			Console.print("La fecha de nacimiento no tiene el formato correcto");
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

	private Citizen anadirCitizen(String name, String surname, String email, Date birth, String address,
			String nationality, String nif) {
		Citizen ciudadano;
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
		return ciudadano;
	}
}
