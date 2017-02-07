package es.uniovi.asw.perosnalLetter;

public class SingletonTextWritter {
	static SingletonTextWritter instance;
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
			this.generadorDocumentoWord = new PlainTextWritter();
		}
		return generadorDocumentoWord;
	}
	public TextWritter getPlaibnTextWritter(){
		if(this.generadorDocumentoPlainText == null){
			this.generadorDocumentoPlainText = new PlainTextWritter();
		}
		return generadorDocumentoPlainText;
	}
}
