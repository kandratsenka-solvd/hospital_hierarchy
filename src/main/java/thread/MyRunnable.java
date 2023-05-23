package thread;

import org.apache.logging.log4j.Logger;
import utils.LoggerUtil;

import java.util.concurrent.CountDownLatch;

public class MyRunnable implements Runnable {

    final Logger LOGGER = LoggerUtil.getLogger();
    private final CountDownLatch latch;

    public MyRunnable(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                LOGGER.info(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            latch.countDown();
            LOGGER.info("The runnable has finished executing.");
        }
    }
}