package es.uniovi.asw;

import es.uniovi.asw.util.Logger.CLLogger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.io.IOException;

@RunWith(Suite.class)
@SuiteClasses({
        ConsoleTest.class,
        LeerArchivoTest.class,
        TestGeneracionDocumentos.class
})
public class AllTests {

}

