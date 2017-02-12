package es.uniovi.asw.personalletter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class PlainTextWritter implements TextWritter {
	private String notCompletePath = "src/test/resources/";

	@Override
	public void createDocument(String documentName, String content) {
		String realPath = notCompletePath + documentName + ".txt";

		new File(realPath);
		FileWriter fileWriter = null;
		BufferedWriter bf = null;
		try {
			fileWriter = new FileWriter(realPath);
			bf = new BufferedWriter(fileWriter);
			String realContent = "CitizensLoader TXT\n\n" + content;
			bf.write(realContent);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bf != null) {
					bf.close();
				}
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
