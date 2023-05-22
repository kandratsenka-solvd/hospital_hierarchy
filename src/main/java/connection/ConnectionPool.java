package connection;

import org.apache.logging.log4j.Logger;
import utils.LoggerUtil;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.locks.ReentrantLock;


public class ConnectionPool {
    final Logger LOGGER = LoggerUtil.getLogger();
    private static final int INITIAL_POOL_SIZE = 5;
    private static final BlockingQueue<Connection> allConnections = new ArrayBlockingQueue<>(INITIAL_POOL_SIZE);
    private final BlockingQueue<Connection> freeConnections;
    private final ReentrantLock lock = new ReentrantLock();
    private static volatile ConnectionPool instance;

    private ConnectionPool() {
        createConnectionList();
        freeConnections = new ArrayBlockingQueue<>(INITIAL_POOL_SIZE);
        freeConnections.addAll(allConnections);
    }

    private static void createConnectionList() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            allConnections.add(new Connection());
        }
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public CompletionStage<Connection> receiveConnection() {
        CompletableFuture<Connection> future = new CompletableFuture<>();
        String currentThreadName = Thread.currentThread().getName();
        try {
            lock.lock();
            int freeConnNum = freeConnections.size();
            Connection connection = freeConnections.poll();
            if (connection != null) {
                LOGGER.info(String.format("Free connections: %s. Received connection: 1.", freeConnNum));
                future.complete(connection);
            } else {
                LOGGER.warn("No available connections.");
                CompletableFuture.supplyAsync(() -> {
                    try {
                        LOGGER.warn(String.format("<==> [%s]. Waiting for connection...", currentThreadName));
                        return freeConnections.take();
                    } catch (InterruptedException e) {
                        LOGGER.error("Error while receiving connection.");
                        throw new RuntimeException(e);
                    }
                }).thenAccept(future::complete);
            }
        } catch (Exception e) {
            future.completeExceptionally(e);
        } finally {
            lock.unlock();
        }
        return future;
    }

    public void returnConnection(Connection connection) {
        freeConnections.offer(connection);
        LOGGER.info("returned the connection.");
    }
}