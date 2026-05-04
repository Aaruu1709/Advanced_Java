package ConcurrencyAPI;

import java.util.concurrent.Semaphore;

class Student extends Thread {

    private Semaphore semaphore;
    private int studentId;

    public Student(Semaphore semaphore, int studentId) {
        this.semaphore = semaphore;
        this.studentId = studentId;
    }

    @Override
    public void run() {

        try {
            System.out.println("Student " + studentId + " waiting for computer...");

            semaphore.acquire(); // take permit

            System.out.println("Student " + studentId + " got computer.");

            Thread.sleep(3000); // using computer

            System.out.println("Student " + studentId + " finished work.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // give permit back
        }
    }
}

public class SemaphoreEx {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2); // only 2 computers

        for (int i = 1; i <= 5; i++) {
            new Student(semaphore, i).start();
        }
    }
}
