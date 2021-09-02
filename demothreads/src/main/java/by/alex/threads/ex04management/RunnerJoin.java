package by.alex.threads.ex04management;

public class RunnerJoin {

    static {
        System.out.println("Thread '" + Thread.currentThread().getName() + "' start");
    }

    public static void main(String[] args) {
        joinThread();
        //yieldThread();
    }

    private static void joinThread() {
        JoinThread t1 = new JoinThread("First Sleep");
        JoinThread t2 = new JoinThread("Second Sleep");
        t1.start();
        t2.start();

        try {
            t1.join(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    private static void yieldThread() {
        YieldThread t1 = new YieldThread("First Yield");
        YieldThread t2 = new YieldThread("Second Yield");
        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

}