package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("# of CPU cores = " + cores + "\n");

        MyThread t1 = new MyThread(2);
        MyThread t2 = new MyThread(3);
        MyThread t3 = new MyThread(5);
        Thread t4 = new Thread(new MyRunnable(7));
        Thread t5 = new Thread(new MyRunnable(11));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        System.out.println("All threads started ...");

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }

        System.out.println("All threads finished.");

        System.out.println("\n============================\n");

        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.execute(new MyRunnable(2));
        pool.execute(new MyRunnable(3));
        pool.execute(new MyRunnable(5));
        pool.execute(new MyRunnable(7));
        pool.execute(new MyRunnable(11));

        pool.shutdown();

        System.out.println("Thread pool tasks started ...");

        try {
            pool.awaitTermination(100L, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }

        System.out.println("All tasks finished;\nABORT.");
    }
}
