package es.uniovi.asw.parser;

import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.reportwritter.WriteReport;
import es.uniovi.asw.util.Exception.CitizenException;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Crea los subcomponentes del parser necesarios para procesar el fichero de
 * entrada.
 */
public abstract class RList implements ReadList {

	private static Insert db = new InsertR();
	protected static final WriteReport reporter = new WreportR();


	abstract List<Citizen>readFile(String path) throws CitizenException;

	@Override
	public List<Citizen> read(String path) throws CitizenException {
		reporter.report("Iniciando lectura de fichero: ["+path+"]");

		checkFile(path);



		List<Citizen> citizens = readFile(path);
		if(citizens.size()!=0)
			db.insert(citizens);
		else{
			reporter.report("No se ha encontrado ningun citizen válido en fichero: ["+path+"]");
		}
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
		ciudadano.setDireccionPostal(address);
		ciudadano.setNacionalidad(nationality);
		ciudadano.setNumero_identificativo(nif);
		// Crea un usuario y contraseña aleatorio
		String con = getCadenaAlfanumAleatoria(4);
		ciudadano.setContrasena(con);
		return ciudadano;
	}

	private void checkFile(String path) throws CitizenException {
		File f = new File(path);
		if(!f.exists() || f.isDirectory()) {
			reporter.report("No se encuentra el fichero especificado");
			throw new CitizenException("No se encuentra el fichero en la ruta especificada");
		}

	}
}
