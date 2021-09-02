package by.alex.threads.ex05a_is_active;

public class RunnerThreadToDisable {

    public static void main(String[] args) {

        System.out.println("Main thread start...");
        ThreadToDisable threadToDisable = new ThreadToDisable();
        Thread thread = new Thread(threadToDisable, "threadToDisable");
        thread.start();

        try {
            Thread.sleep(100);

            threadToDisable.disable();
            //thread.join();

            Thread.sleep(1000);
            //Thread.yield();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
            e.printStackTrace();
        }
        System.out.println("Main thread end...");
    }

}
