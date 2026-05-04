package ConcurrencyAPI;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockUnlock {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Runnable task = () -> {

            lock.lock(); // take lock

            try {
                System.out.println(Thread.currentThread().getName() + " entered");

                Thread.sleep(2000);

                System.out.println(Thread.currentThread().getName() + " leaving");

            } catch (Exception e) {
            } finally {
                lock.unlock(); // release lock
            }
        };

        new Thread(task, "Thread-1").start();
        new Thread(task, "Thread-2").start();
        new Thread(task, "Thread-3").start();
    }
}

//Only one thread at a time enters.
//Important Best Practice
//
//For lock always use:
//try {
//   lock.lock();
//} finally {
//   lock.unlock();
//}

//------------------------------

//For semaphore:
//
//acquire();
//try {
//   work
//} finally {
//   release();
//}