package service.impl;

import domain.Matrix;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class MatrixSemaphoreFillThread implements Runnable {

    private final int id;
    private final Matrix matrix;
    private final Semaphore semaphore;
    private final AtomicBoolean isDone = new AtomicBoolean(false);

    public MatrixSemaphoreFillThread(int id, Matrix matrix, Semaphore semaphore) {
        this.id = id;
        this.matrix = matrix;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        if (!isDone.get()) {
            int index = 0;
            try {
                semaphore.acquire();
                index = findEmptyIndex(index);
                if (index != -1) {
                    matrix.setElement(index, index, id);
                } else {
                    isDone.set(true);
                }
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } finally {
                semaphore.release();
            }
        }
    }

    private int findEmptyIndex(int index) {
        for (int i = index; i < matrix.getRows(); i++) {
            if (matrix.getElement(i, i) == 0) {
                return i;
            }
        }
        return -1;
    }

}
