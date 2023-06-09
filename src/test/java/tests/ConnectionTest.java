package tests;

import connection.Connection;
import connection.ConnectionPool;
import org.testng.annotations.Test;
import java.util.concurrent.*;

public class ConnectionTest {

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
                        CompletableFuture<Void> future = new CompletableFuture<>();
                        try {
                            Connection.performAction();
                        } finally {
                            connectionPool.returnConnection(connection);
                            latch.countDown();
                            future.complete(null);
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
