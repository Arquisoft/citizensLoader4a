package es.uniovi.asw.personalletter;

import es.uniovi.asw.util.Exception.CitizenException;

import java.io.*;

class PlainTextWritter implements TextWritter {
	private String notCompletePath = "src/test/resources/";

	@Override
	public void createDocument(String documentName, String content) throws CitizenException {
		String realPath = notCompletePath + documentName + ".txt";

		new File(realPath);
		FileWriter fileWriter = null;
		BufferedWriter bf = null;
		try {
			fileWriter = new FileWriter(realPath);
			bf = new BufferedWriter(fileWriter);
			String realContent = "CitizensLoader TXT\n\n" + content;
			bf.write(realContent);

		}catch (IOException e) {
				throw new CitizenException("Error al generar documento txt" +
						" ["+ realPath+"] | ["+this.getClass().getName()+"]");

		}finally {
			close(bf);
			close(fileWriter);
		}
		}

		public static void close(Closeable c) {
			if (c == null) return;
			try {
				c.close();
			} catch (IOException e) {
				//log the exception
			}
		}

}
