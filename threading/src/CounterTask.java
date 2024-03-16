/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 */
public class CounterTask extends Thread {

    private double interval = 1;
    private final int id;
    private static int counter = 0;

    @Override
    public void run() {
        System.out.println("running counter task with ID: " + id + " ( interval: " + interval + ")");
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep((long) (interval* 1000));
                System.out.println("counter[" + id + "] is at " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("counter task: " + id + " completed");
    }

    public CounterTask() {
        id = ++counter;
        this.start();
    }

    public CounterTask(double interval) {
        id = ++counter;
        this.interval = interval;
        this.start();
    }

}
