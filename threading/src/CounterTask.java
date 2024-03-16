/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 */
public class CounterTask extends BaseTask {

    public CounterTask() {
        super();
        this.start();
    }

    public CounterTask(double interval) {
        super(interval);
        this.start();
    }

    @Override
    public void run() {
        super.run();
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep((long) (interval * 1000));
                System.out.println("counter[" + id + "] is at " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("counter task: " + id + " completed");
    }
}
