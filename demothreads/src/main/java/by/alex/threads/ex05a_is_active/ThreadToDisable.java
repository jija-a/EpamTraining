package by.alex.threads.ex05a_is_active;

public class ThreadToDisable implements Runnable {

    private boolean isActive;

    void disable() {
        isActive = false;
    }

    ThreadToDisable() {
        isActive = true;
    }

    public void run() {

        System.out.printf("Thread %s start... \n", Thread.currentThread().getName());
        int counter = 1;
        while (isActive) {
            System.out.println("Cycle " + counter++);
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                e.printStackTrace();
            }*/
        }
        System.out.printf("Thread %s end... \n", Thread.currentThread().getName());
    }

}
