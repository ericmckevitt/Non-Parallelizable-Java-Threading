import java.util.concurrent.*;

public class SharingData {

    /*
    * This implementation is not thread-safe because the increment operation is not atomic.
    * Running this program will result in a different value for counter each time, always < 20_000_000.
     */
    public volatile static int counter = 0;
    public static void increment(String name) {
        System.out.printf("%s: begin\n", name);
        for (int i = 0; i < 10_000_000; i++)
            counter = counter + 1;
        System.out.printf("%s: done\n", name);
    }
    public static void main(String[] args) throws Exception {
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
