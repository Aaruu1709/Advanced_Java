package Multithreading;
class MyThread2 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+ ":"+ i);

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("Thread inturrupted");
            }
        }
    }
}
public class Multithreading2 {
    public static void main(String[] args) {
        MyThread2 myThread2=new MyThread2();
        MyThread2 myThread1=new MyThread2();
        myThread1.setName("payment 1");
        myThread2.setName("order 2");


        myThread2.start();
        myThread1.start();

    }
}
