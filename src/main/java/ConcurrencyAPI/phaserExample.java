package ConcurrencyAPI;

import java.util.concurrent.Phaser;

public class phaserExample {

    public static void main(String[] args) {

        Phaser phaser = new Phaser(3);

        Runnable task = () -> {

            String name = Thread.currentThread().getName();

            System.out.println(name + " completed Phase 1");
            phaser.arriveAndAwaitAdvance();

            System.out.println(name + " completed Phase 2");
            phaser.arriveAndAwaitAdvance();

            System.out.println(name + " completed Final Phase");
        };

        new Thread(task, "T1").start();
        new Thread(task, "T2").start();
        new Thread(task, "T3").start();
    }
}
