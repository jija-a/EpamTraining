package by.alex.threads.ex12producer_consumer_reentrant_lock;

public class ProducerConsumerApp {

    public static void main(String[] args) {

        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

