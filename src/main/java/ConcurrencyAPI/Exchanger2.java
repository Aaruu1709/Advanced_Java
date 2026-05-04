import java.util.concurrent.Exchanger;

public class Exchanger2 {

    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();

        Runnable t1 = () -> {
            try {
                String received =
                        exchanger.exchange("Apple");

                System.out.println("Thread-1 got: " + received);

            } catch (Exception e) {
            }
        };

        Runnable t2 = () -> {
            try {
                String received =
                        exchanger.exchange("Orange");

                System.out.println("Thread-2 got: " + received);

            } catch (Exception e) {
            }
        };

        new Thread(t1).start();
        new Thread(t2).start();
    }
}
