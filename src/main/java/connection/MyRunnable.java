package connection;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing MyRunnable in thread: " + Thread.currentThread().getName());
    }
}