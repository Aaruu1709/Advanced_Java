package executor_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable{
    private int taskId;
    public MyTask(int taskId){
        this.taskId=taskId;
    }

    @Override
    public void run(){
        System.out.println("task "+ taskId + "executed by "+ Thread.currentThread().getName());
        try{
            Thread.sleep(2000);
        }catch (Exception e){

        }
    }

    }

public class FixedThreadPoolEx {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(2);
        for(int i=1;i<=5;i++){
            executor.submit(new MyTask(i));
        }
        executor.shutdown();

    }
}
