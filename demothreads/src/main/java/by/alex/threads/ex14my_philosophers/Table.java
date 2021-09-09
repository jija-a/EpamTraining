package by.alex.threads.ex14my_philosophers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Table {

    private final Semaphore semaphore;
    private final Queue<Fork> forks;

    public Table(LinkedList<Fork> forks, Semaphore semaphore) {
        this.forks = forks;
        this.semaphore = semaphore;
    }

    public Fork getFork(int maxWaitMillis) throws ResourсeException {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                return forks.poll();
            }
        } catch (InterruptedException e) {
            throw new ResourсeException(e);
        }
        throw new ResourсeException(":превышено время ожидания");
    }

    public void putFork(Fork fork) {
        forks.add(fork); // возвращение экземпляра в пул
        semaphore.release();
    }

}
