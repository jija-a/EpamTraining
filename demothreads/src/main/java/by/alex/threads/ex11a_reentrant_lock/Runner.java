package by.alex.threads.ex11a_reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) {

        CommonResource commonResource = new CommonResource();
        ReentrantLock locker = new ReentrantLock(); // создаем заглушку
        for (int i = 1; i < 6; i++) {

            Thread t = new Thread(new CountThread(commonResource, locker));
            t.setName("Поток " + i);
            t.start();
        }
    }

}

