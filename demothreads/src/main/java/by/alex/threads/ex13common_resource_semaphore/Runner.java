package by.alex.threads.ex13common_resource_semaphore;

import java.util.concurrent.Semaphore;

public class Runner {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(1, false); // 1 разрешение, беспорядочно
        CommonResource res = new CommonResource();
        new Thread(new CountThread(res, sem, "CountThread 1")).start();
        new Thread(new CountThread(res, sem, "CountThread 2")).start();
        new Thread(new CountThread(res, sem, "CountThread 3")).start();
        new Thread(new CountThread(res, sem, "CountThread 4")).start();
        new Thread(new CountThread(res, sem, "CountThread 5")).start();
        new Thread(new CountThread(res, sem, "CountThread 6")).start();
        new Thread(new CountThread(res, sem, "CountThread 7")).start();
        new Thread(new CountThread(res, sem, "CountThread 8")).start();
        new Thread(new CountThread(res, sem, "CountThread 9")).start();
        new Thread(new CountThread(res, sem, "CountThread 10")).start();
    }

}
