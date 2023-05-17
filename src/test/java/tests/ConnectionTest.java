package tests;

import connection.MyRunnable;
import org.testng.annotations.Test;


public class ConnectionTest {

    @Test
    public void testMultiThread() {
        Thread thread1 = new Thread(new MyRunnable(), "Thread 1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread 2");

        thread1.start();
        thread2.start();
    }

    @Test
    public void testConnectionPool() {

    }
}
