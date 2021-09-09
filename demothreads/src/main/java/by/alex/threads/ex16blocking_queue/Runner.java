package by.alex.threads.ex16blocking_queue;

public class Runner {

    public static void main(String[] args) {

        CommonResource resource = new CommonResource();

        Thread t1 = new Thread(new GetThread(resource));
        Thread t2 = new Thread(new PutThread(resource));

            t1.start();
            t2.start();
    }

}
