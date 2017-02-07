package es.uniovi.asw.perosnalLetter;

public class SingletonTextWritter {
	SingletonTextWritter instance;
	private TextWritter generadorDocumentoPDF;
	private TextWritter generadorDocumentoWord;
	private TextWritter generadorDocumentoPlainText;
	
	private SingletonTextWritter(){
		
	}
	
	
	public SingletonTextWritter getInstance(){
		if(this.instance == null){
			this.instance = new SingletonTextWritter();
		}
		return this.instance;
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
