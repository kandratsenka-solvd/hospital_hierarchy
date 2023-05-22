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
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        CountDownLatch latch = new CountDownLatch(7);
        for (int i = 0; i < 7; i++) {
            executorService.submit(() -> {
                try {
                    CompletionStage<Connection> connectionStage = connectionPool.receiveConnection();
                    connectionStage.thenAccept(connection -> {
                        LOGGER.info(String.format("Thread %s received connection.", Thread.currentThread().getName()));
                        try {
                            LOGGER.info(String
                                    .format("Thread %s is performing some action...", Thread.currentThread().getName()));
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            connectionPool.returnConnection(connection);
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