package by.alex.threads.ex05b_interrupt;

public class InterruptThread extends Thread {

    public InterruptThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter = 1;
        while (!isInterrupted()) {

            System.out.println("Cycle " + counter++);
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

}
