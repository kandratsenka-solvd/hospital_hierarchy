package tests;

import connection.Connection;
import connection.ConnectionPool;
import connection.MyRunnable;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.LoggerUtil;

import java.util.concurrent.*;


public class ConnectionTest {
    final Logger LOGGER = LoggerUtil.getLogger();

    @Test
    public void testMultiThread() {
        Thread thread1 = new Thread(new MyRunnable(), "Thread 1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread 2");
        thread1.start();
        thread2.start();
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