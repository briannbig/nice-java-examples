package executorsApi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread starts....");

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new SimpleCounter());
        executorService.submit(new SimpleCounter(1.3));
        executorService.submit(new SimpleCounter(1.5));
        executorService.submit(new SimpleCounter());

        executorService.shutdown();
        // the following throws a java.util.concurrent.RejectedExecutionException
        // executorService.submit(new SimpleCounter());


        System.out.println("... Main thread ends");
    }
}
