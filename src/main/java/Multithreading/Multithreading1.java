package Multithreading;

class MyClass implements Runnable{
    public void run(){
        for(int i=0;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+":"+ i);
        }
    }
}
public class Multithreading1 {
    public static void main(String[] args) {
     MyClass myClass=new MyClass();

     Thread thread1=new Thread(myClass,"Thread-1");
     Thread thread2=new Thread(myClass,"Thread-2");

     thread1.start();
     thread2.start();
    }
}
//How to Explain in Interview
//
//“In this example, I created a class implementing Runnable
// and placed business logic inside the run() method.
//
//Then I created two Thread objects: t1 and t2.
//
//When we call start(), Java creates separate threads and
// internally invokes run() on each thread. Both threads execute
// concurrently,
// so output order may vary depending on CPU scheduling.”
//“We should call start() instead of directly calling run(),
// because run() executes like a normal method,
// while start() creates a new thread.”

//“In real production applications, instead of manually creating threads,
// we usually use ExecutorService thread pools for better resource management.”

//“This demonstrates/show how multiple independent
// tasks can run simultaneously using multithreading in Java.”

//Important Difference
//If You Call run() Directly
//t1.run();
//
//
//It behaves like a normal method call.
//
//No new thread created
//Runs on main thread
//If You Call start()
//t1.start();
//
//New thread created
//Separate call stack assigned
//JVM schedules it
//New thread executes run()