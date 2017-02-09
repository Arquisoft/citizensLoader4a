package es.uniovi.asw.dbUpdate;

import es.uniovi.asw.model.Citizen;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Verifica los datos de entrada y si falta algún atributo obligatorio genera el correspondiente error.
 */
public class InsertP implements Insert{
	
	


	@Override
	public void insert(List<Citizen> ciudadanos) {
		EntityManager mapper = Hibernate_Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		for(Citizen ci : ciudadanos){
			Hibernate_Jpa.getManager().persist(ci);
		}
		trx.commit();
		mapper.close();


	}
}
