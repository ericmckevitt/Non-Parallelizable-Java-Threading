import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitLocks {

    public volatile static int counter = 0;
    private static Lock lock = new ReentrantLock();

    public static void increment(String name) {
        System.out.printf("%s: begin\n", name);
        for (int i = 0; i < 10_000_000; i++) {
            lock.lock();
            counter = counter + 1;
            lock.unlock();
        }
        System.out.printf("%s: done\n", name);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.printf("main: begin (counter = %d)\n", counter);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<?> f1 = executor.submit(() -> increment("A"));
        Future<?> f2 = executor.submit(() -> increment("B"));
        f1.get();
        f2.get();
        executor.shutdown();
        System.out.printf("main: end (counter = %d)\n", counter);
    }
}
