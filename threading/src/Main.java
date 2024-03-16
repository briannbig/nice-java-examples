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

        // Creating threads using Threads API: 2nd technique
//        new TensCounterTask().start();
//        new TensCounterTask(1.7).start();

        // Creating threads using Threads API: 3rd technique
//        new TwentiesCounterTask(1.2);
        // Creating threads using Threads API: 4th technique
//        new Thread( new  ThirtiesCounterTask(1.4)).start();

        // Creating threads using Threads API: 5th technique
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous implementation of Runnable interface ");
                for (int i = 1; i <= 10; i++) {
                    try {
                        Thread.sleep((long) (1.6 * 1000));
                        System.out.println("Anonymous counter is at " + i * 40);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("Anonymous counter task completed");
            }
        }).start();

        Thread.sleep(5000);
        System.out.println("Main thread ends....");

    }
}