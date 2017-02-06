package es.uniovi.asw;

import es.uniovi.asw.util.HibernateUtility;
import org.hibernate.SessionFactory;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);
	}

	// TODO
	void run(String... args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		System.out.println("Session Factory : " + sessionFactory.hashCode());
	}
	}

