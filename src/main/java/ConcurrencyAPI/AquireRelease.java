package ConcurrencyAPI;

import java.util.concurrent.Semaphore;

//2. Semaphore Acquire / Release Example
//Allow 2 Threads at Same Time
public class AquireRelease {
    static Semaphore semaphore=new Semaphore(2);

    public static void main(String[] args) {
        Runnable task=()->{
            try{
                semaphore.acquire();//take permit
                System.out.println(Thread.currentThread().getName()+ "Entered....");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+ " leaving...");
                semaphore.release();//return permit

            }catch (Exception e){

            }
        };
        new Thread(task, "Thread-1").start();
        new Thread(task, "Thread-2").start();
        new Thread(task, "Thread-3").start();
        new Thread(task, "Thread-4").start();
    }
}
//Meaning
//Because:
//Semaphore(2)
//Only 2 threads together allowed.
//Others wait
//
//
// Lock = single room key
//Semaphore = limited entry passes
//Important Best Practice
//For lock always use:
//
//try {
//   lock.lock();
//} finally {
//   lock.unlock();
//}
//For semaphore:
//
//acquire();
//try {
//   work
//} finally {
//   release();
//}.