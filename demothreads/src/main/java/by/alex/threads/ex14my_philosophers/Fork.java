package by.alex.threads.ex14my_philosophers;

import java.util.concurrent.Semaphore;

public class Fork extends Semaphore {

    private static final int DEFAULT_PERMITS = 1;
    private boolean status;

    public Fork(int permits) {
        super(permits);
    }

    public Fork() {
        super(DEFAULT_PERMITS);
    }

    public Fork(int permits, boolean fair) {
        super(permits, fair);
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
