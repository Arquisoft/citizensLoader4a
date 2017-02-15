package es.uniovi.asw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        ConsoleTest.class,
        LeerArchivoTest.class,
        TestGeneracionDocumentos.class,
        CalculatorTest.class
})
public class AllTests {

}

