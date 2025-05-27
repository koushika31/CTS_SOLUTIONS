class MessagePrinter implements Runnable {
    private String message;
    private int times;

    public MessagePrinter(String message, int times) {
        this.message = message;
        this.times = times;
    }

    public void run() {
        for (int i = 1; i <= times; i++) {
            System.out.println(message + " " + i);
            try {
                Thread.sleep(500); // pause for half a second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MessagePrinter("Hello from Thread 1", 5));
        Thread thread2 = new Thread(new MessagePrinter("Hello from Thread 2", 5));

        thread1.start();
        thread2.start();
    }
}
