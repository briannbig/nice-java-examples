package threadsApi;

/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("threadsApi.Main thread starts...");

//        Creating threads using Threads API: 1st technique
        new threadsApi.CounterTask(2);
        new threadsApi.CounterTask(1.5);
        new threadsApi.CounterTask();

//         Creating threads using Threads API: 2nd technique
        new threadsApi.TensCounterTask().start();
        new threadsApi.TensCounterTask(1.7).start();

//         Creating threads using Threads API: 3rd technique
        new threadsApi.TwentiesCounterTask(1.2);
//         Creating threads using Threads API: 4th technique
        new Thread(new threadsApi.ThirtiesCounterTask(1.4)).start();

//         Creating threads using Threads API: 5th technique
        new Thread(() -> {
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
        }).start();

        Thread.sleep(5000);
        System.out.println("threadsApi.Main thread ends....");

    }
}