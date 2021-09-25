package service.impl;

import domain.Matrix;
import service.MatrixService;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class MatrixLockFillThread implements Runnable {

    private final int id;
    private final Matrix matrix;
    private final ReentrantLock lock;
    private final AtomicBoolean isDone = new AtomicBoolean(false);

    public MatrixLockFillThread(int id, Matrix matrix) {
        this.lock = new ReentrantLock();
        this.id = id;
        this.matrix = matrix;
    }

    @Override
    public void run() {

        while (!isDone.get()) {
            int index = 0;
            try {
                lock.lock();
                index = findEmptyIndex(index);
                if (index != -1) {
                    matrix.setElement(index, index, id);
                } else {
                    isDone.set(true);
                }
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace(); //todo
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
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
