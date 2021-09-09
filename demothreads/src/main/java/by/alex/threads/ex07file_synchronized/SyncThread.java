package by.alex.threads.ex07file_synchronized;

public class SyncThread extends Thread {

    private final Resource resource;

    public SyncThread(String name, Resource resource) {
        super(name);
        this.resource = resource;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.writing(getName(), i); // место срабатывания синхронизации
        }
    }

}
