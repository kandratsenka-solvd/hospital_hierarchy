package connection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ConnectionPool {
    private static final int INITIAL_POOL_SIZE = 5;
    private static final BlockingQueue<Connection> allConnections = new ArrayBlockingQueue<>(INITIAL_POOL_SIZE);
    private BlockingQueue<Connection> freeConnections;

    private static final ConnectionPool instance = new ConnectionPool();

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
        return instance;
    }

    public CompletableFuture<Connection> receiveConnection() {
        CompletableFuture<Connection> future = new CompletableFuture<>();
        try {
            Connection connection = freeConnections.take();
            future.complete(connection);
        } catch (InterruptedException e) {
            future.completeExceptionally(e);
        }
        return future;
    }


    public void returnConnection(CompletableFuture<Connection> connectionFuture) {
        if (connectionFuture.isDone()) {
            try {
                Connection connection = connectionFuture.get();
                freeConnections.offer(connection);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}