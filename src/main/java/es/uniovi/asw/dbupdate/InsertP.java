package es.uniovi.asw.dbupdate;

import es.uniovi.asw.dbupdate.util.Hibernate_Jpa;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.reportwritter.GenerateLogText;
import es.uniovi.asw.reportwritter.WriteReport;
import es.uniovi.asw.util.Comprobador;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Verifica los datos de entrada y si falta algún atributo obligatorio genera el
 * correspondiente error.
 */
public class InsertP implements Insert {

	private static final WriteReport reporter = new WreportR();

	@Override
	public void insert(List<Citizen> ciudadanos) {
		EntityManager mapper = Hibernate_Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		int it = 0;
		for (Citizen ci : ciudadanos) {
			it++;
			boolean todoOK = false;

			StringBuilder mensajeLog = new StringBuilder();

			boolean name = Comprobador.esTodoTexto(ci.getNombre());
			boolean apellidos = Comprobador.esTodoTexto(ci.getApellidos());
			boolean email = Comprobador.emailNoVacio(ci.getEmail());
//			boolean fechaNac = ci.getFechaNacimiento() == null ? false : true;
			boolean fechaNac = Comprobador.esFecha(ci.getFechaNacimiento().toString());
			boolean direccion = ci.getDireccionPostal() == null ? false : true;
			boolean nif = ci.getNumeroIdentificativo() == null ? false : true;
			boolean nacionalidad = Comprobador.esTodoTexto(ci.getNacionalidad());

			

			if (name && apellidos && email && direccion && fechaNac && nif && nacionalidad) {
				todoOK = true;
			}
			if (todoOK) {
				if (CitizenFinder.findByNif(ci.getNumeroIdentificativo()) == null) {
					mapper.persist(ci);
				} else {

					reporter.report("Repetido en la base de datos");

				}
			}else{
				GenerateLogText.completeTextForLog(mensajeLog, name, apellidos, email, fechaNac, direccion, nacionalidad,
						nif, it);
				reporter.report(mensajeLog.toString());
			}

		}
		trx.commit();
		mapper.close();

	}
}
