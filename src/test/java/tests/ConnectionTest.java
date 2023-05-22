package tests;

import connection.Connection;
import connection.ConnectionPool;
import connection.MyRunnable;
import connection.MyThread;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.LoggerUtil;

import java.util.concurrent.*;


public class ConnectionTest {
    final Logger LOGGER = LoggerUtil.getLogger();

    @Test
    public void testRunnable() {
        int numberOfThreads = 5;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            MyRunnable myThread = new MyRunnable(latch);
            Thread thread = new Thread(myThread);
            thread.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testMultiThread() {
        int numberOfThreads = 5;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            MyThread myThread = new MyThread(latch);
            myThread.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testConnectionPool() throws InterruptedException {
        int threadsNumber = 7;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        ExecutorService executorService = Executors.newFixedThreadPool(threadsNumber);
        CountDownLatch latch = new CountDownLatch(threadsNumber);
        for (int i = 0; i < threadsNumber; i++) {
            executorService.submit(() -> {
                try {
                    CompletionStage<Connection> connectionStage = connectionPool.receiveConnection();
                    connectionStage.thenAccept(connection -> {
                        LOGGER.info("Received the connection.");
                        try {
                            LOGGER.info("Is performing some action...");
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            connectionPool.returnConnection(connection);
                            LOGGER.info("returned the connection.");
                            latch.countDown();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        latch.await();
        executorService.shutdown();
    }
}