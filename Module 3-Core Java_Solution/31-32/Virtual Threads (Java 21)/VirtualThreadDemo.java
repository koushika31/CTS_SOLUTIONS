public class VirtualThreadDemo {

    private static final int THREAD_COUNT = 100_000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting virtual threads...");

        Thread[] vThreads = new Thread[THREAD_COUNT];
        long startVirtual = System.currentTimeMillis();

        for (int i = 0; i < THREAD_COUNT; i++) {
            vThreads[i] = Thread.startVirtualThread(() -> {
                // Print thread name once
                System.out.println("Virtual Thread: " + Thread.currentThread().getName());
            });
        }

        // Wait for all virtual threads to complete
        for (Thread t : vThreads) {
            t.join();
        }

        long endVirtual = System.currentTimeMillis();
        System.out.println("Virtual threads completed in " + (endVirtual - startVirtual) + " ms");
    }
}
