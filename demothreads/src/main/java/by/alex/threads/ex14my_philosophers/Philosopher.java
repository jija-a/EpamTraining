package by.alex.threads.ex14my_philosophers;

public class Philosopher implements Runnable {
    private enum State {
        HUNGRY, EATING, THINKING;
    }

    Table table;
    Fork left;
    Fork right;

    public Philosopher(Fork leftFork, Fork rightFork, Table table) {
        this.left = leftFork;
        this.right = rightFork;
        this.table = table;
    }

    @Override
    public void run() {
        eat();
    }

    private void eat() {

    }

}
