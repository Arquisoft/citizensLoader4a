package es.uniovi.asw.personalletter;

public class SingletonTextWritter {
	private static SingletonTextWritter instance;
	private TextWritter generadorDocumentoPDF;
	private TextWritter generadorDocumentoWord;
	private TextWritter generadorDocumentoPlainText;
	
	private SingletonTextWritter(){
		
	}
	
	
	public static SingletonTextWritter getInstance(){
		if(instance == null){
			instance = new SingletonTextWritter();
		}
		return instance;
	}
	
	public TextWritter getPDFTextrWitter(){
		if(this.generadorDocumentoPDF == null){
			this.generadorDocumentoPDF = new PDFTextWritter();
		}
		return generadorDocumentoPDF;
	}
	public TextWritter getWordTextWritter(){
		if(this.generadorDocumentoWord == null){
			this.generadorDocumentoWord = new WordTextWritter();
		}
		return generadorDocumentoWord;
	}
	public TextWritter getPlainTextWritter(){
		if(this.generadorDocumentoPlainText == null){
			this.generadorDocumentoPlainText = new PlainTextWritter();
		}
		return generadorDocumentoPlainText;
	}
}
