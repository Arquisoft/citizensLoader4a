package es.uniovi.asw.parser;

import es.uniovi.asw.dbUpdate.Insert;
import es.uniovi.asw.model.Citizen;

import java.util.*;

/**
 * Crea los subcomponentes del parser necesarios para procesar el fichero de
 * entrada.
 */
public abstract class RList implements ReadList {

	private static Insert db = new InsertR();

	abstract List<Citizen>readFile(String path);

	@Override
	public List<Citizen> read(String path){
		List<Citizen> citizens = readFile(path);
		db.insert(citizens);
		return citizens;
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



	protected Citizen anadirCitizen(String name, String surname, String email, Date birth, String address,
			String nationality, String nif) {
		Citizen ciudadano;
		ciudadano = new Citizen();
		ciudadano.setNombre(name);
		ciudadano.setApellidos(surname);
		ciudadano.setEmail(email);
		ciudadano.setFecha_nacimiento(birth);
		ciudadano.setDireccion_postal(address);
		ciudadano.setNacionalidad(nationality);
		ciudadano.setNumero_identificativo(nif);
		// Crea un usuario y contraseña aleatorio
		String con = getCadenaAlfanumAleatoria(4);
		ciudadano.setContrasena(con);
		return ciudadano;
	}
}
