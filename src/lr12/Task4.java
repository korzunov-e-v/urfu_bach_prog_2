package lr12;

public class Task4 {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
            });
            thread.start();
        }

    }

}
