package ConcurrencyAPI;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchAllMethods {

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(3);

        Runnable task = () -> {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " finished");
                latch.countDown();
                System.out.println("Remaining: " + latch.getCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(task, "Worker-1").start();
        new Thread(task, "Worker-2").start();
        new Thread(task, "Worker-3").start();

        System.out.println("Waiting...");

        boolean completed = latch.await(5, TimeUnit.SECONDS);

        System.out.println("Completed? " + completed);
        System.out.println(latch.toString());
    }
}
//| Method              | Purpose                    |
//| ------------------- | -------------------------- |
//| `await()`           | Wait forever until count=0 |
//| `await(time, unit)` | Wait with timeout          |
//| `countDown()`       | Reduce count               |
//| `getCount()`        | Current count              |
//| `toString()`        | Debug state                |

//Breakdown
//Example:
//java.util.concurrent.CountDownLatch@5acf9800[Count = 2]
//
//Meaning:
//Part	Meaning
//java.util.concurrent.CountDownLatch	Class name
//@5acf9800	Object hashcode / identity
//[Count = 2]	Current remaining count