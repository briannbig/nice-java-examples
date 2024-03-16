/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 * this class does not have {@link Thread}'s start() method in it's constructors and hence the {@link Thread}'s
 * run() method will be executed when start() mehod is called on the {@link TensCounterTask}'s object
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
