public class Serial {
    public static int counter = 0;
    public static void increment(String name) {
        System.out.printf("%s: begin\n", name);
        for (int i = 0; i < 20_000_000; i++)
            counter = counter + 1;
        System.out.printf("%s: done\n", name);
    }

    public static void main(String[] args) {
        System.out.printf("main: begin (counter = %d)\n", counter);
        increment("A");
        System.out.printf("main: end (counter = %d)\n", counter);
    }
}
