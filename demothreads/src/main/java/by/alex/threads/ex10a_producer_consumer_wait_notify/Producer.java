package by.alex.threads.ex10a_producer_consumer_wait_notify;

class Producer extends Thread {//implements Runnable {

    Store store;

    Producer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}

