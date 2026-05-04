package ConcurrencyAPI;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch3 {

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(3);

        Runnable student = () -> {

            String name = Thread.currentThread().getName();

            System.out.println(name + " is joining exam...");

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }

            System.out.println(name + " joined.");

            latch.countDown(); // one student joined
        };

        new Thread(student, "Student-1").start();
        new Thread(student, "Student-2").start();
        new Thread(student, "Student-3").start();

        System.out.println("Teacher waiting for all students...");

        latch.await(); // wait for all 3 students

        System.out.println("All students joined. Exam Started!");
    }
}
//CountDownLatch = “Don’t start until everyone is ready.”
//Important Note
//If one student never joins:
//countDown()
//Teacher keeps waiting.
//Better Safe Version
//Use timeout:
//latch.await(5, TimeUnit.SECONDS);
//Wait max 5 seconds.

//CountDownLatch
//Used for waiting until tasks/events complete
//“Wait until count becomes zero.”

//Semaphore
//Used for limiting how many threads can access something at once.
//“Allow only limited entries.”