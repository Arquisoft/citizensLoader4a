package es.uniovi.asw.personalletter;


import es.uniovi.asw.util.exception.CitizenException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Implementacion de escritor de word
 */
class WordTextWritter implements TextWritter {

	private static String FILE_PATH = "src/test/resources/";



	@Override
	public void createDocument(String documentName, String content) throws CitizenException {

        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph pg = doc.createParagraph();



            XWPFRun run = pg.createRun();
            run.setFontFamily("Calibri");
            run.setFontSize(20);
            run.setText(content);
        try {
            FileOutputStream out = new FileOutputStream(FILE_PATH+documentName+".docx");
            doc.write(out);
            out.close();
            doc.close();
        } catch (IOException e) {
            throw new CitizenException("Error al generar documento word" +
                    " ["+ FILE_PATH+documentName+".docx] | ["+this.getClass().getName()+"]");
        }






		
	}

}
