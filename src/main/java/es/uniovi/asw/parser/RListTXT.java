package es.uniovi.asw.parser;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.util.Console;
import es.uniovi.asw.util.Exception.CitizenException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RListTXT extends RList implements ReadList {



	@Override
	public List<Citizen> readFile(String path) throws CitizenException {
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

		String cadena;

		try {
			FileReader f = new FileReader(path);
			BufferedReader b = new BufferedReader(f);

			while ((cadena = b.readLine()) != null) {
				row++;
				String[] datos = cadena.split(";");
				if (datos.length != 7){
					throw new CitizenException("En la linea: ["+row+"] faltan" +
							" datos del ciudadano. No se ha añadido a la base de datos| ["+this.getClass().getName()+"]");
				}
			//		reporter.report("\tEn la linea " + row
					//+ " faltan datos del ciudadano, no se ha podido añadir a la base de datos");
				else {
					name = datos[0];
					surname = datos[1];
					email = datos[2];
					birth = datos[3];
					address = datos[4];
					nationality = datos[5];
					nif = datos[6];
					ciudadanos.add(anadirCitizen(name, surname, email, new SimpleDateFormat("dd/MM/yyyy").parse(birth),
							address, nationality, nif));

				}
			}
			b.close();
		} catch (ParseException e) {
			// e.printStackTrace();
			reporter.report("La fecha de nacimiento no tiene el formato correcto");
			Console.print("La fecha de nacimiento no tiene el formato correcto");
			throw  new CitizenException("Error en el formato de fecha | ["+this.getClass().getName()+"]");

		} catch (IOException e) {
			String[] fileName = path.split("/");
			// e.printStackTrace();
			reporter.report("El fichero " + fileName[fileName.length - 1] + " no existe");
			Console.print("El fichero " + fileName[fileName.length - 1] + " no existe");
			throw  new CitizenException("El fichero no existe | ["+this.getClass().getName()+"]");



		}

		// Crear el fichero log
		String[] cachos = path.split("/");
		String nombreFich1 = cachos[cachos.length - 1];

		return ciudadanos;
	}
}
