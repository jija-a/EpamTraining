package by.alex.threads.ex03priority;

public class PriorityRunner {

    static {
        System.out.println("Thread '" + Thread.currentThread().getName() + "' start");
    }

    public static void main(String[] args) {
        PriorityThread min = new PriorityThread("Min");
        PriorityThread max = new PriorityThread("Max");
        PriorityThread norm = new PriorityThread("Norm");

        //priorityThread();
        priorityWithSleepThread(min, max, norm);

        System.out.println("Thread '" + Thread.currentThread().getName() + "' end");
    }

    private static void priorityWithSleepThread(Thread min, Thread max, Thread norm) {
        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        norm.setPriority(Thread.NORM_PRIORITY);

        max.start();
        norm.start();
        min.start();
        try {
            min.join();
            max.join();
            norm.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void priorityThread(Thread min, Thread max, Thread norm) {
        min.setPriority(1);
        max.setPriority(5);
        norm.setPriority(3);

        min.start();
        norm.start();
        max.start();
    }

}
