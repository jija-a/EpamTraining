package by.alex.threads.ex11c_stampted_lock;

import java.util.concurrent.locks.StampedLock;

public class ThreadTest {

    static long counter;
    static StampedLock sl = new StampedLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> counterReader(1));
        Thread t2 = new Thread(() -> counterReader(2));
        Thread t3 = new Thread(ThreadTest::counterWriter);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void counterReader(int id) {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                long stamp = sl.tryOptimisticRead(); // берем метку состояния
                long tmp = counter; // читаем значение общей переменной
                if (!sl.validate(stamp)) { // проверяем метку состояния,
                    System.out.println("    id:" + id + " protected value has been changed");
                    stamp = sl.readLock(); // если состояние изменилось, ставим блокировку
                    System.out.println("    id:" + id + " new readLock");
                    try {
                        tmp = counter; // читаем данные под блокировкой
                    } finally {
                        sl.unlockRead(stamp); // снимаем блокировку
                    }
                }
                System.out.println("    id:" + id + " current value:" + tmp);
                Thread.sleep(1_000);
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    private static void counterWriter() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                long stamp = sl.writeLock(); // выставляем блокировку на запись
                try {
                    long tmp = counter;
                    System.out.println("start counter modification:" + tmp);
                    Thread.sleep(10_000);
                    tmp++;
                    counter = tmp; // изменяем общую переменную.
                    System.out.println("end counter modification:" + tmp);
                } finally {
                    sl.unlockWrite(stamp); //снимаем блокировку на запись
                }
                Thread.sleep(30_000);
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

}
