package es.uniovi.asw.personalletter;

import es.uniovi.asw.util.exception.CitizenException;

public interface TextWritter {
	
	void createDocument(String documentName, String content) throws CitizenException;

}
