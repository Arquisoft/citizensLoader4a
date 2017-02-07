package es.uniovi.asw.perosnalLetter;

public class SingletonTextWritter {
	SingletonTextWritter instance;
	private TextWritter generadorDocumento;
	
	private SingletonTextWritter(){
		
	}
	
	
	public SingletonTextWritter getInstance(){
		if(this.instance == null){
			this.instance = new SingletonTextWritter();
		}
		return this.instance;
	}
	
	public TextWritter getPDFTextWritter(){
		if(this.generadorDocumento == null || this.generadorDocumento.getClass().equals(PDFTextWritter.class)){
			this.generadorDocumento = new PDFTextWritter();
		}
		return generadorDocumento;
	}
	public TextWritter getWordTextWritter(){
		if(this.generadorDocumento == null || this.generadorDocumento.getClass().equals(WordTextWritter.class)){
			this.generadorDocumento = new PlainTextWritter();
		}
		return generadorDocumento;
	}
	public TextWritter getPlaibnTextWritter(){
		if(this.generadorDocumento == null || this.generadorDocumento.getClass().equals(PlainTextWritter.class)){
			this.generadorDocumento = new PlainTextWritter();
		}
		return generadorDocumento;
	}
}
