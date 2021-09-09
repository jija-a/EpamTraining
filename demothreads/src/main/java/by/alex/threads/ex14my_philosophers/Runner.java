package by.alex.threads.ex14my_philosophers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Runner {

    private static final int FORKS_QTY = 5;

    //todo
    public static void main(String[] args) {

        LinkedList<Fork> forks = new LinkedList<>();
        forks.add(new Fork());
        forks.add(new Fork());
        forks.add(new Fork());
        forks.add(new Fork());
        forks.add(new Fork());

        List<Thread> philosophers = new ArrayList<>();
        Semaphore semaphore = new Semaphore(FORKS_QTY, false);
        Table table = new Table(forks, semaphore);

        philosophers.add(new Thread(new Philosopher(forks.get(0), forks.get(1), table)));
        philosophers.add(new Thread(new Philosopher(forks.get(1), forks.get(2), table)));
        philosophers.add(new Thread(new Philosopher(forks.get(2), forks.get(3), table)));
        philosophers.add(new Thread(new Philosopher(forks.get(3), forks.get(4), table)));
        philosophers.add(new Thread(new Philosopher(forks.get(4), forks.get(0), table)));

        philosophers.forEach(Thread::start);
    }

}
