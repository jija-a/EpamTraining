package by.alex.threads.ex05c_daemon;

public class SimpleThread extends Thread {

    public SimpleThread() {
    }

    public void run() {
        int count = 0;

        while (true) {
            System.out.println("Hello from Simple thread " + count++);

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread" + getName() +"interrupted");
                e.printStackTrace();
            }
        }
    }

}
