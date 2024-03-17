package executorsApi;

/**
 * @author <a href="briannbig@gmail.com">Brian Barasa </a>
 */
public class TensCounter extends BaseTask {

    public TensCounter() {
        super();
        interval =  Math.random();
    }


    @Override
    void setTaskName() {
        taskName = TensCounter.class.getSimpleName();
    }

    @Override
    public void run() {
        super.run();
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep((long) (interval * 1000));
                System.out.println(taskName + "[" + id + "] is at " + i * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(taskName + " [" + id + "] COMPLETED");
    }

}
