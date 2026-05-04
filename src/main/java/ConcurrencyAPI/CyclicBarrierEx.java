package ConcurrencyAPI;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierEx {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3);

        Runnable student = () -> {

            try {
                String name = Thread.currentThread().getName();

                System.out.println(name + " reached exam hall");

                barrier.await();   // wait for others

                System.out.println(name + " started exam");

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(student, "Student-1").start();
        new Thread(student, "Student-2").start();
        new Thread(student, "Student-3").start();
    }
}
