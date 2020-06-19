package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private Log() {
    }

    private static final Logger LOGGER = LogManager.getLogger("utils.Log");

    public static void info(String msg) {
        LOGGER.info(msg);
    }

    public static void debug(String msg) {
        LOGGER.debug(msg);
    }

    public static void error(Exception e) {
        LOGGER.error(e);
        LOGGER.error(e.getStackTrace());
    }
}