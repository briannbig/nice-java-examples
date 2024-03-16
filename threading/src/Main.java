/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts...");
        /*
        Creating threads using Threads API: 1st technique
         new CounterTask(2);
        new CounterTask(1.5);
        new CounterTask(); */
        new TensCounterTask().start();
        new TensCounterTask(1.7).start();

        // Creating threads using Threads API: 2nd technique
        Thread.sleep(5000);
        System.out.println("Main thread ends....");

    }
}