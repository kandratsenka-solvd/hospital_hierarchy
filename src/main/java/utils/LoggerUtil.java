package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class LoggerUtil {

    private static final Logger LOGGER = LogManager.getLogger();

    public static Logger getLogger() {
        return LOGGER;
    }

    public static void info(String logMessage) {
        LOGGER.info(logMessage);
    }

    public static void warn(String logMessage) {
        LOGGER.warn(logMessage);
    }

    public static void error(String logMessage) {
        LOGGER.error(logMessage);
    }
}