/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 */
public abstract class BaseTask extends Thread {
    protected double interval = 1;
    protected final int id;
    private static int counter = 0;

    public BaseTask() {
        id = ++counter;
    }

    public BaseTask(double interval) {
        id = ++counter;
        this.interval = interval;
    }

    @Override
    public void run() {
        System.out.println("running counter task with ID: " + id + " ( interval: " + interval + ")");
    }
}
