package es.uniovi.asw.reportwritter;

/**
 * Clase singleton para la crecion de instancias de reporte
 */
public class SingletonReporter {
	private static SingletonReporter instance = null;
	private WriteReport reporter;
	
	private SingletonReporter(){
		this.reporter = null;
	}
	
	public static SingletonReporter getInstance(){
		if(instance == null){
			instance = new SingletonReporter();
		}
		return instance;
	}
	
	public WriteReport getWreportP(){
		if(this.reporter == null){
			this.reporter = new WreportP();
		}
		return this.reporter;
	}
	
}
