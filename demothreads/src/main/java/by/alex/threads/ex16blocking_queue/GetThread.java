package by.alex.threads.ex16blocking_queue;

public class GetThread implements Runnable {

    CommonResource resource;

    public GetThread(CommonResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                System.out.println("Element " + resource.take() + " took");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
