package project.utils;

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



//    private static final Logger LOGGER = LogManager.getLogger();
//
//    public static void makeMessage(String logMessage) {
//        Level level = determineLogLevel(logMessage);
//        System.out.println(level.toString());
//        LOGGER.log(level, logMessage);
//    }
//
//    private static Level determineLogLevel(String logMessage) {
//        if (logMessage.startsWith("FATAL")) {
//            return Level.FATAL;
//        } else if (logMessage.startsWith("ERROR")) {
//            return Level.ERROR;
//        }else if (logMessage.startsWith("WARN")) {
//            return Level.WARN;
//        } else if (logMessage.startsWith("INFO")) {
//            return Level.INFO;
//        } else {
//            return Level.DEBUG;
//        }
//    }

}