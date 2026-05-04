package executor_framework;

class OrderTask extends Thread{
    private int orderId;
    OrderTask(int orderId){
        this.orderId=orderId;
    }
    public  void run(){
        System.out.println("Processing orde:"+ orderId+ " by "+ Thread.currentThread().getName());

        try{
            Thread.sleep((5000));//duplicate work
        }catch (Exception e){

        }
        System.out.println("complete orders:"+ orderId);
    }
}

public class OldWayToCreateThread {
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            OrderTask task=new OrderTask(i);//create thread at a time 5
            task.start();//here start thread
        }
    }
}
//What Happens Here?
//
//For every order:
//New Thread object created
//New OS thread requested
//Memory allocated
//Thread starts
//After work done → thread dies
//So for 5 orders:
//👉 5 threads created manually
//--------------------------------------------
//Real Problem in Large Scale

//Real Problem in Large Scale
//
//Imagine:
//
//500 API requests
//1000 emails
//2000 reports
//
//If you create new thread every time:
//
//new Thread(...).start();
//new Thread(...).start();
//new Thread(...).start();
//
//
//Then problems:
//
//❌ Too many threads
//❌ High memory usage
//❌ CPU overload
//❌ Context switching heavy
//❌ Slow server
//❌ Hard to control
//-------------------------------------

//Why This Was Painful
//
//As developer, you manually handled:
//
//create thread
//start thread
//lifecycle
//too many threads
//resource waste
//-------------------------------------------------

//Real Backend Example (Old Style)
//for every API request:
//   create new Thread
//   process request
//   destroy thread
//
//
//Very expensive.

//Why Executor Framework Came (Very Simple Language)
//
//Old way had one big problem:
//
//Every small work needed a new thread.
//
//Example:
//
//You want to send:
//
//100 emails
//200 API requests
//500 orders
//
//Old way:
//
//new Thread()
//new Thread()
//new Thread()
//
//
//again and again.
//
//What Issues Happened?
//1. Too Slow
//
//Creating thread takes time.
//
//If every task creates new thread → system slow.
//
//2. Memory Waste
//
//Every thread needs memory (stack etc.)
//
//1000 threads = high memory usage.
//
//3. CPU Pressure
//
//Too many threads fight for CPU.
//
//System becomes heavy.
//
//4. Hard to Manage
//
//Developer must handle:
//
//start thread
//stop thread
//track thread
//errors
//
//Very messy.
//
//Executor Framework Simple Solution
//
//Instead of creating new worker every time:
//
//👉 Keep 5 workers ready
//👉 Give them tasks one by one
//
//Like office employees.
//
//No need to hire new employee for every file.
//----------------------------------
//Real Life Example
//Old Way:
//
//Need tea 10 times = hire 10 new people
//
//Executor Framework:
//
//Keep 2 workers in kitchen
//Give all tea orders one by one
//
//Better + faster + cheaper
//
//One-Line Answer
//
//Executor Framework came because creating new thread for
// every task was slow, costly, and difficult to manage.
//Reuse threads instead of creating new thread every time.
//Use Java Executor Framework
//
//Because it:
//
//✅ Reuses existing threads
//✅ Saves memory
//✅ Faster execution
//✅ Better performance
//✅ Easy management
//✅ Handles many tasks efficiently

//===============================================================
//Thread Pool — Basic Definition
//A Thread Pool is a group of pre-created reusable worker
// threads kept ready to execute tasks.
//
//Instead of creating a new thread every time,
// tasks are assigned to available threads from the pool.


//Simple Language
//
//Think of a company office:
//
//5 employees already hired
//New work comes in
//Give work to free employee
//After finishing, employee becomes available again
//
//No need to hire a new employee for every task.
//
//That is exactly how thread pool works.
//Technical Meaning
//Threads are created once
//Stored in pool
//Tasks are submitted
//Free thread picks task
//After completion thread returns to pool
//Reused for next task
//A Thread Pool is a collection of reusable
// worker threads used to execute multiple tasks efficiently

//===========================================================

//How Thread Pool Works Internally
//
//A Thread Pool mainly works using 3 parts:
//
//Worker Threads
//Task Queue
//Pool Manager / Executor

//====================================================
//In Computer Terms
//
//If pool size = 3
//
//Tasks arrive:
//
//Task1 -> Thread1
//Task2 -> Thread2
//Task3 -> Thread3
//Task4 -> Queue
//Task5 -> Queue
//Task6 -> Queue
//
//
//When Thread2 finishes:
//
//Task4 leaves queue -> Thread2
//
//Why not create unlimited threads?
//
//Because too many threads:
//
//consume memory
//slow system
//too much switching overhead
//
//So we keep limited workers.
//Thread pool = limited permanent workers + waiting line for extra jobs.

//======================================================================



