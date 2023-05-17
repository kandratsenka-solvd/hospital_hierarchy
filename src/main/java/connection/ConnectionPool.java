package connection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class ConnectionPool {
    private final Semaphore semaphore;
    private BlockingQueue<Connection> pool;

    public ConnectionPool(int poolSize) {
        semaphore = new Semaphore(poolSize);
        pool = new ArrayBlockingQueue<>(poolSize);
        initializePool(poolSize);
    }

    private void initializePool(int poolSize) {
        for (int i = 0; i < poolSize; i++) {
            pool.offer(new Connection());
        }
    }

    public Connection getConnection() throws InterruptedException {
        semaphore.acquire();
        return pool.poll();
    }

    public void releaseConnection(Connection connection) {
        pool.offer(connection);
        semaphore.release();
    }
}