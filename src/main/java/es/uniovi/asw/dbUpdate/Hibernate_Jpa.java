package es.uniovi.asw.dbUpdate;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * The Class Hibernate_Jpa
 */
public class Hibernate_Jpa {

    /** The emf. */
    private static EntityManagerFactory emf = null;

    /** The em thread. */
    private static ThreadLocal<EntityManager> emThread =
            new ThreadLocal<EntityManager>();

    /**
     * Creates the entity manager.
     *
     * @return the entity manager
     */
    public static EntityManager createEntityManager() {
        EntityManager entityManager = getEmf().createEntityManager();
        emThread.set(entityManager);
        return entityManager;
    }

    /**
     * Gets the manager.
     *
     * @return the manager
     */
    public static EntityManager getManager() {
        return emThread.get();
    }

    /**
     * Gets the emf.
     *
     * @return the emf
     */
    private static EntityManagerFactory getEmf() {
        if (emf == null) {
            String persistenceUnitName = loadPersistentUnitName();
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        }
        return emf;
    }

    /**
     * Load persistent unit name.
     *
     * @return the string
     */
    private static String loadPersistentUnitName() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(
                    Hibernate_Jpa.class.getResourceAsStream("/META-INF/persistence.xml"));

            doc.getDocumentElement().normalize();
            NodeList nl = doc.getElementsByTagName("persistence-unit");

            return ((Element) nl.item(0)).getAttribute("name");

        } catch (ParserConfigurationException e1) {
            throw new RuntimeException(e1);
        } catch (SAXException e1) {
            throw new RuntimeException(e1);
        } catch (IOException e1) {
            throw new RuntimeException(e1);
        }
    }

}
