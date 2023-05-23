package tests;

import thread.MyRunnable;
import thread.MyThread;
import org.testng.annotations.Test;
import java.util.concurrent.*;


public class ThreadTest {

    private final int numberOfThreads = 5;

    @Test
    public void testRunnable() {
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
}