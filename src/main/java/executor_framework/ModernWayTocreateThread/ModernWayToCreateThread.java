package executor_framework.ModernWayTocreateThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ModernWayToCreateThread {

    public static void main(String[] args) {

        // Create thread pool with 2 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit 5 tasks
        for (int i = 1; i <= 5; i++) {

            int taskId = i;

            executor.submit(() -> {

                System.out.println(
                        "Task " + taskId +
                                " started by " +
                                Thread.currentThread().getName()
                );

                try {
                    Thread.sleep(2000); // simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(
                        "Task " + taskId +
                                " completed by " +
                                Thread.currentThread().getName()
                );
            });
        }

        // Stop accepting new tasks
        executor.shutdown();

        System.out.println("Main thread finished.");
    }
}
