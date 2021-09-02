package by.alex.threads.ex05b_interrupt;

public class InterruptThreadRunner {

    static {
        System.out.println("Main thread started...");
    }

    public static void main(String[] args) {

        InterruptThread thread = new InterruptThread("InterruptThread");
        thread.start();

        try {
            Thread.sleep(150);

            thread.interrupt();

            Thread.sleep(150);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
            e.printStackTrace();
        }
        System.out.println("Main thread finished...");
    }

}
