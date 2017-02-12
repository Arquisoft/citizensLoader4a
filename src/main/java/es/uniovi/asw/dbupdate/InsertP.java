package es.uniovi.asw.dbupdate;

import es.uniovi.asw.dbupdate.util.Hibernate_Jpa;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.reportwritter.WriteReport;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Verifica los datos de entrada y si falta algún atributo obligatorio genera el correspondiente error.
 */
public class InsertP implements Insert {

	private static final WriteReport reporter = new WreportR();


	@Override
	public void insert(List<Citizen> ciudadanos) {
		EntityManager mapper = Hibernate_Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		for (Citizen ci : ciudadanos) {

			if (CitizenFinder.findByNif(ci.getNumeroIdentificativo()) == null) {
				mapper.persist(ci);
			} else {

				reporter.report("Repetido en la base de datos");

			}





		}
		trx.commit();
		mapper.close();

	}
}
