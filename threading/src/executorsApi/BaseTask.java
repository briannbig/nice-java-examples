package executorsApi;

/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 * <p>
 * definition of the base task
 */
public abstract class BaseTask implements Runnable {

    protected int id;
    private static int count = 0;
    protected double interval = 1;
    protected String taskName;

    abstract void setTaskName();

    public BaseTask() {
        id = ++count;
        setTaskName();
    }

    public BaseTask(double interval) {
        this();
        this.interval = interval;
    }

    @Override
    public void run() {
        System.out.println("running " + taskName + " with ID: " + id + " at interval: " + interval + " seconds");

    }
}
