package ConcurrencyAPI;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {
    static ReentrantLock lock=new ReentrantLock();

    public static void main(String[] args) {
        outer();
    }
    static  void outer(){
        lock.lock();
        try {
            System.out.println("outer method start..");

            inner();
            System.out.println("outer ethod end....");
        }
        finally {
            lock.unlock();
        }
    }
    static void inner(){
        lock.lock();
        try{
            System.out.println("inner method");
        }
        finally {
            lock.unlock();
        }
    }
}
