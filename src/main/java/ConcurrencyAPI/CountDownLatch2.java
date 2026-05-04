package ConcurrencyAPI;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch2 {

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(3);

        Runnable task = () -> {

            String name = Thread.currentThread().getName();

            System.out.println(name + " started work");

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }

            System.out.println(name + " finished work");

            latch.countDown(); // task completed
        };

        new Thread(task, "Worker-1").start();
        new Thread(task, "Worker-2").start();
        new Thread(task, "Worker-3").start();

        System.out.println("Main thread waiting...");

        latch.await(); // wait until count = 0

        System.out.println("All tasks completed. Dashboard Ready.");
    }
}
