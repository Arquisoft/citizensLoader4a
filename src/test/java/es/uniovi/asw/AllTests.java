package es.uniovi.asw;

import es.uniovi.asw.util.logger.CLLogger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.io.IOException;

@RunWith(Suite.class)
@SuiteClasses({
        ConsoleTest.class,
        LeerArchivoTest.class,
        TestGeneracionDocumentos.class,
        CalculatorTest.class,
        TestAplicacion.class
})

public class AllTests {
    @BeforeClass
    public static void setUp() {
        try {
            CLLogger.setup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

