package by.alex.threads.ex16blocking_queue;

public class PutThread implements Runnable {

    CommonResource resource;

    public PutThread(CommonResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        for (int i = 1; i < 15; i++) {
            try {
                resource.put("Java " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
