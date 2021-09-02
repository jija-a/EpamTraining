package by.alex.threads.ex05c_daemon;

public class Main {

    static {
        System.out.println("Main Thread started");
    }

    public static void main(String[] args) {
        SimpleThread thread = new SimpleThread();
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(7500);
        } catch (InterruptedException e) {
            System.out.println("Thread" + Thread.currentThread().getName() + " interrupted");
            e.printStackTrace();
        }

        System.out.println("Main Thread ending");
    }

}
