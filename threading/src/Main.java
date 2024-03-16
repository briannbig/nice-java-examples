/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts...");
        new CounterTask(2);
        new CounterTask(1.5);
        new CounterTask();

        Thread.sleep(5000);
        System.out.println("Main thread ends....");

    }
}