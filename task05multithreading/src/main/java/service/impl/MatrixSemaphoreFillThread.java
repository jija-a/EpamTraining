package service.impl;

import domain.Matrix;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class MatrixSemaphoreFillThread implements Runnable {

    private final int id;
    private final Matrix matrix;
    private final Semaphore semaphore;
    private final AtomicBoolean isDone = new AtomicBoolean();

    public MatrixSemaphoreFillThread(int id, Matrix matrix, Semaphore semaphore) {
        this.id = id;
        this.matrix = matrix;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        if (!isDone.get()) {
            try {
                semaphore.acquire();
                int index = findEmptyIndex();
                if (index != -1) {
                    matrix.setElement(index, index, id);
                } else {
                    isDone.set(false);
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

    private int findEmptyIndex() {
        for (int i = 0; i < matrix.getRows(); i++) {
            if (matrix.getElement(i, i) == 0) {
                return i;
            }
        }
        return -1;
    }

}
