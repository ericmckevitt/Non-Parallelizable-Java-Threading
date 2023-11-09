import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInt {
    public static AtomicInteger counter = new AtomicInteger(0);

    public static void increment(String name) {
        System.out.printf("%s: begin\n", name);
        for (int i = 0; i < 10_000_000; i++)
            counter.incrementAndGet();
        System.out.printf("%s: done\n", name);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.printf("main: begin (counter = %d)\n", counter.get());
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<?> f1 = executor.submit(() -> increment("A"));
        Future<?> f2 = executor.submit(() -> increment("B"));
        f1.get();
        f2.get();
        executor.shutdown();
        System.out.printf("main: end (counter = %d)\n", counter.get());
    }
}
