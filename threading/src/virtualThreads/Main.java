
void main() {

    System.out.println("A dive into virtual threads");

    try {
        methodA();
    } catch (InterruptedException e) {
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