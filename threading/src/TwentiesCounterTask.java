/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 * this demonstrates how to achieve threading utilizing Thread API by immplementing the {@link Runnable} interface. <br>
 * This is more like declaring this class as task
 */
public class TwentiesCounterTask implements Runnable {
    protected double interval = 1;
    protected final int id;
    private static int counter = 0;

    public TwentiesCounterTask() {
        id = ++counter;
        // passing this object as the task to the thread object
        new Thread(this).start();
    }

    public TwentiesCounterTask(double interval) {

        id = ++counter;
        this.interval = interval;
        // passing this object as the task to the thread object
        new Thread(this).start();
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
