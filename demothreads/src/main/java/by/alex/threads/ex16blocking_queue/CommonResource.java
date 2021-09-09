package by.alex.threads.ex16blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CommonResource {

    final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);

    public void put(String element) throws InterruptedException {
        queue.put(element);
        System.out.println("Element " + element + " added");
    }

    public String take() throws InterruptedException {
        return queue.take();
    }

}
