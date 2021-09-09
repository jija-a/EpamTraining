package by.alex.threads.ex14philisophers;

import java.util.concurrent.Semaphore;

class Philosopher extends Thread {
    Semaphore sem;
    int num = 0;
    int id;
    static int idCounter = 0;

    Philosopher(Semaphore sem) {
        this.sem = sem;
        this.id = ++idCounter;
    }

    public void run() {
        try {
            while (num < 3)// пока количество приемов пищи не достигнет 3
            {
                // Запрашиваем у семафора разрешение на выполнение
                sem.acquire();
                System.out.println("Философ " + id + " садится за стол");
                // философ ест
                sleep(500);
                num++;

                System.out.println("Философ " + id + " выходит из-за стола");
                sem.release();

                // философ гуляет
                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("у философа " + id + " проблемы со здоровьем");
        }
    }
}
