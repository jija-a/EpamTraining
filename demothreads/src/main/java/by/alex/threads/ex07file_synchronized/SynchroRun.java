package by.alex.threads.ex07file_synchronized;

import java.io.IOException;

public class SynchroRun {

    public static void main(String[] args) {

        Resource resource = null;
        try {
            resource = new Resource("demothreads\\src\\main\\resources\\synchronized.txt");
            SyncThread t1 = new SyncThread("First", resource);
            SyncThread t2 = new SyncThread("Second", resource);
            t1.start();
            t2.start();

            t1.join();
            t2.join();
        } catch (IOException e) {
            System.err.print("file error: " + e);
        } catch (InterruptedException e) {
            System.err.print("thread error: " + e);
        } finally {
            if (resource != null) {
                resource.close();
            }
        }
    }

}
