package threadsApi;

/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 * this demonstrates how to achieve threading utilizing Thread API by immplementing the {@link Runnable} interface. <br>
 * This is more like declaring this class as task. It is similar to {@link TwentiesCounterTask} except that the {@link Thread}
 * instance is created by calling it on the objects class
 */
public class ThirtiesCounterTask implements Runnable {
    protected double interval = 1;
    protected final int id;
    private static int counter = 0;

    public ThirtiesCounterTask() {
        id = ++counter;
    }

    public ThirtiesCounterTask(double interval) {
        id = ++counter;
        this.interval = interval;
    }

    @Override
    public void run() {
        System.out.println("running counter task with ID: " + id + " ( interval: " + interval + ")");
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep((long) (interval * 1000));
                System.out.println("counter[" + id + "] is at " + i * 20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("counter task: " + id + " completed");
    }
}
