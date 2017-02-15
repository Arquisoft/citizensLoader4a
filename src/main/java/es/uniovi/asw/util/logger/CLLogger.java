package es.uniovi.asw.util.logger;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by pelay on 11/02/2017.
 */
public class CLLogger {

    static private FileHandler file;
    static private Formatter formatter;

    static public void setup() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        file = new FileHandler("src/test/resources/logCL.log",true);
        formatter = new CustomFormatter();
        file.setFormatter(formatter);
        logger.addHandler(file);
        logger.setUseParentHandlers(false);

    }
}
