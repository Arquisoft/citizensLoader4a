package es.uniovi.asw;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.util.Console;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.junit.Assert.*;



/**
 * Created by Pelayo Garcia Lartategui on 04/02/2017.
 */
public class ConsoleTest {

    private String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private  ByteArrayInputStream in;
    @Before
    public void setUp() throws Exception {
       in = new ByteArrayInputStream("test in".getBytes());
        System.setOut(new PrintStream(outContent));
        System.setIn(in);


    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
        System.setIn(System.in);

    }

    @Test
    public void println() throws Exception {
        Console.println("Test println");
        assertEquals("Test println"+newLine,outContent.toString());
    }

    @Test
    public void println1() throws Exception {
        Citizen c = new Citizen("Pelayo","Garcia","email@email.com",
                new Date(),"Gijon","Española","563587A");
        Console.println(c);
        assertEquals(c.toString()+newLine,outContent.toString());

    }

    @Test
    public void print() throws Exception {
        Console.print("Test println");
        assertEquals("Test println",outContent.toString());

    }

    @Test
    public void printf() throws Exception {

        Console.printf("the %s jumped over the %s, %d times", "cow", "moon", 2);
        assertEquals("the cow jumped over the moon, 2 times",outContent.toString());

    }


    @Test
    public void readString1() throws Exception {

        String s = Console.readString("Test readString");
        assertEquals("test in",s);
        assertEquals("Test readString: ",outContent.toString());



    }

}