package service.impl;

import domain.Matrix;
import service.MatrixService;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class MatrixLockFillThread implements Runnable {

    private final int id;
    private final Matrix matrix;
    private final ReentrantLock lock;
    private final AtomicBoolean isDone = new AtomicBoolean();

    public MatrixLockFillThread(int id, Matrix matrix) {
        this.lock = new ReentrantLock();
        this.id = id;
        this.matrix = matrix;
    }

    @Override
    public void run() {

        if (!isDone.get()) {
            try {
                lock.lock();
                int index = findEmptyIndex();
                if (index != -1) {
                    matrix.setElement(index, index, id);
                } else {
                    isDone.set(false);
                }
            } finally {
                lock.unlock();
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
