import java.util.concurrent.*;
import java.util.*;

public class CallableExecutorDemo {

    public static void main(String[] args) {
        // Create a fixed thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Create a list of Callable tasks
        List<Callable<String>> taskList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            taskList.add(() -> {
                Thread.sleep(500); // simulate work
                return "Result from Task " + taskId;
            });
        }

        try {
            // Submit all tasks and collect Future objects
            List<Future<String>> results = executor.invokeAll(taskList);

            // Process the results
            for (Future<String> future : results) {
                System.out.println(future.get()); // blocks until result is available
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor
            executor.shutdown();
        }
    }
}
