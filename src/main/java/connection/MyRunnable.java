package connection;

import org.apache.logging.log4j.Logger;
import utils.LoggerUtil;

public class MyRunnable implements Runnable {

    final Logger LOGGER = LoggerUtil.getLogger();

    @Override
    public void run() {
        LOGGER.info("Executing MyRunnable in thread: " + Thread.currentThread().getName());
    }
}