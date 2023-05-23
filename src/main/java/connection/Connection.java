package connection;

import org.apache.logging.log4j.Logger;
import utils.LoggerUtil;


public class Connection {

    private static final Logger LOGGER = LoggerUtil.getLogger();

    public static void performAction() {
        try {
            LOGGER.info("Is performing some action...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
