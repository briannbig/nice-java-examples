import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

void main() {

    System.out.println("A dive into virtual threads");

    try {
        methodA();
        methodB();
    } catch (InterruptedException | ExecutionException e) {
        throw new RuntimeException(e);
    }

}

/**
 * Creating a Virtual Thread with the {@link Thread} Class and the {@link Thread.Builder} Interface
 */
void methodA() throws InterruptedException {
    // We call the Thread.ofVirtual() method to create an instance of Thread.Builder for creating virtual threads.
    Thread thread = Thread.ofVirtual().start(() -> System.out.println("Hello virtual threads!"));
    thread.join();

    // creating a virtual thread named MyThread with the Thread.Builder interface:
    Thread.Builder builder = Thread.ofVirtual().name("AnotherThread");
    Runnable task = () -> System.out.println("Running thread");
    Thread thread2 = builder.start(task);
    System.out.println(STR."Thread2 name: \{thread2.getName()}");
    thread2.join();

}

/**
 * Creating and Running a Virtual Thread with the {@link Executors#newVirtualThreadPerTaskExecutor()} Method
 */
void methodB() throws ExecutionException, InterruptedException {
    // This example creates an ExecutorService with the Executors.newVirtualThreadPerTaskExecutor() method.
    // Whenever ExecutorService.submit(Runnable) is called, a new virtual thread is created and started to run the task.
    // This method returns an instance of Future. Note that the method Future.get() waits for the thread's task to complete.
    // Consequently, this example prints a message once the virtual thread's task is complete.


    ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor();
    Future<?> future = myExecutor.submit(() -> System.out.println("Running thread"));
    future.get();
    System.out.println("Task completed");

}