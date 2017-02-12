package es.uniovi.asw.util;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by pelay on 11/02/2017.
 */
public class CLLogger {

    static private FileHandler file;
    static private SimpleFormatter formatter;

    static public void setup() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        file = new FileHandler("src/test/resources/logCL.log");
        formatter = new SimpleFormatter();
        file.setFormatter(formatter);
        logger.addHandler(file);
    }
}
