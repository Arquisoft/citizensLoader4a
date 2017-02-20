package es.uniovi.asw;

import java.io.IOException;
import es.uniovi.asw.util.logger.CLLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Clase para probar la aplicacion por comandos.
 * 
 * @author Javier Castro
 *
 */
public class TestAplicacion {

	final LoadCitizens runner = new LoadCitizens();



	LoadCitizens app;
	String[] args;
	String filesLocation;
	
	@Before
	public void setUp(){
		filesLocation  = "src/test/resources/";
		args=new String[2];
		args[1]=filesLocation;
	}
	@Test
	public void leerExcel() {
		args[0] = "readExcel";
		args[1]= args[1]+"test.xlsx";

		Assert.assertEquals(0,runner.run(args));


	}
	@Test
	public void leerTxt() {
		args[0] = "readTxt";
		args[1]= args[1]+"test.txt";

		Assert.assertEquals(0,runner.run(args));

	}
	
	@Test
	public void leerTxtMal() {
		args[0] = "readTxtAD";
		args[1]= args[1]+"test.txt";
		

		Assert.assertEquals(1,runner.run(args));

	}
	@Test
	public void logtest() throws IOException {
		CLLogger cl = new CLLogger();
		cl.setup();
		assertTrue(true);

	}

	@Test
	public void sendPDF() {
		args=new String[4];
		String a=filesLocation;
		args[0] = "readExcel";
		args[1]= a+"test.xlsx";
		args[2]= "sendPDF";
		args[3]= a+"archivoGenerado";
		
		//Console.println("A leer un txt con el comando: "+args);
		Assert.assertEquals(0,runner.run(args));
	}

	@Test
	public void sendDOC() {
		args=new String[4];
		String a=filesLocation;
		args[0] = "readExcel";
		args[1]= a+"test.xlsx";
		args[2]= "sendDOC";
		args[3]= a+"archivoGenerado";
		
		//Console.println("A leer un txt con el comando: "+args);
		Assert.assertEquals(0,runner.run(args));
	}

	@Test
	public void sendTXT() {
		args=new String[4];
		String a=filesLocation;
		args[0] = "readExcel";
		args[1]= a+"test.xlsx";
		args[2]= "sendTXT";
		args[3]= a+"archivoGenerado";
		//Console.println("A leer un txt con el comando: "+args);
		Assert.assertEquals(0,runner.run(args));
	}
	
	@Test
	public void sendDOCMal() {
		/*args=new String[3];
		args[1]=filesLocation;
		args[0] = "readExcel";
		args[1]= args[1]+"test.xlsx";
		args[2]= "sendDOCMAL";
		
		Assert.assertEquals(1,runner.run(args));*/
	}
	
	@Test
	public void cllogger() throws IOException {
		CLLogger c= new CLLogger();
		c.setup();
	}
}
