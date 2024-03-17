package executorsApi;

/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 */
public class SimpleCounter extends BaseTask {

    public SimpleCounter() {
        super();
    }

    public SimpleCounter(double interval) {
        super(interval);
    }

    @Override
    void setTaskName() {
        taskName = SimpleCounter.class.getSimpleName();
    }

    @Override
    public void run() {
        super.run();
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep((long) (interval * 1000));
                System.out.println(taskName + "[" + id + "] is at " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(taskName + " [" + id + "] COMPLETED");
    }

}
