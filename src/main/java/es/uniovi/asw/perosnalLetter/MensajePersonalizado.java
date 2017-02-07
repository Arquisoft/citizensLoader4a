package es.uniovi.asw.perosnalLetter;

import es.uniovi.asw.model.Citizen;

public class MensajePersonalizado {
	
	String message;
	
	public MensajePersonalizado(){
		
	}
	
	public String getMessage(Citizen c){
		generateMessage(c);
		
		return this.message;
	}
	private void generateMessage(Citizen c){
		/*
		 * Hacer el mensaje con los datos del citizen
		 */
		
		this.message = "Lo que sea";
	}
}
