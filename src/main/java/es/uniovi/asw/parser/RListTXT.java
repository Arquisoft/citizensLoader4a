package es.uniovi.asw.parser;

import es.uniovi.asw.dbupdate.WreportR;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.reportwritter.GenerateLogText;
import es.uniovi.asw.reportwritter.WriteReport;
import es.uniovi.asw.util.Comprobador;
import es.uniovi.asw.util.Console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RListTXT extends RList implements ReadList {

	private static final WriteReport reporter = new WreportR();

	@Override
	public List<Citizen> readFile(String path) {
		List<Citizen> ciudadanos = new ArrayList<Citizen>();

		String name;
		String surname;
		String email;
		String birth;
		String address;
		String nationality;
		String nif;
		int row = 0;
		StringBuilder logger = new StringBuilder();

		boolean nameResult, surnameResult, emailResult, birthResult, addressResult, nationalityResult, nifResult = true;
		String cadena;

		try {
			FileReader f = new FileReader(path);
			BufferedReader b = new BufferedReader(f);

			while ((cadena = b.readLine()) != null) {
				row++;
				String[] datos = cadena.split(",");
				if (datos.length != 7)
					reporter.report("\tEn la linea "
							+ row
							+ " faltan datos del ciudadano, no se ha podido añadir a la base de datos");
				else {
					name = datos[0];
					nameResult = Comprobador.esTodoTexto(name);
					surname = datos[1];
					surnameResult = Comprobador.esTodoTexto(name);
					email = datos[2];
					emailResult = Comprobador.esEmailCorrecto(email);
					birth = datos[3];
					birthResult = Comprobador.esFecha(birth);
					address = datos[4];
					addressResult = Comprobador.esAddressCorrecto(address);
					nationality = datos[5];
					nationalityResult = Comprobador.esTodoTexto(nationality);
					nif = datos[6];
					nifResult = nif != null ? true : false;
					boolean todoOK = GenerateLogText.completeTextForLog(logger,
							nameResult, surnameResult, emailResult,
							birthResult, addressResult, nationalityResult,
							nifResult, row);
					if (todoOK) {
						ciudadanos
								.add(anadirCitizen(name, surname, email,
										new SimpleDateFormat("dd/MM/yyyy")
												.parse(birth), address,
										nationality, nif));
					}
				}
			}
			b.close();
		} catch (ParseException e) {
			//e.printStackTrace();

			Console.print("La fecha de nacimiento no tiene el formato correcto");
		} catch (IOException e) {
			String[] fileName = path.split("/");
			//e.printStackTrace();
			Console.print("El fichero " + fileName[fileName.length - 1]
					+ " no existe");

		} catch (Exception e) {
			e.printStackTrace();

		}

		// Crear el fichero log
		String[] cachos = path.split("/");
		String nombreFich1 = cachos[cachos.length - 1];

		return ciudadanos;
	}
}
