/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 */
public class TensCounterTask extends BaseTask {
    public TensCounterTask() {
        super();
    }

    public TensCounterTask(double interval) {
        super(interval);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep((long) (interval * 1000));
                System.out.println("counter[" + id + "] is at " + i * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("counter task: " + id + " completed");
    }
}
