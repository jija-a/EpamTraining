package service.impl;

import domain.Matrix;

import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

class MatrixLockFillThread implements Runnable {

    private final int id;
    private final Matrix matrix;
    private final ReentrantLock lock;

    public MatrixLockFillThread(int id, Matrix matrix) {
        this.lock = new ReentrantLock();
        this.id = id;
        this.matrix = matrix;
    }

    @Override
    public void run() {

        lock.lock();
        try {
            Optional<Integer> dIndex = Storage.STORAGE.getIndexes().stream().findAny();
            if (dIndex.isPresent()) {
                matrix.setElement(dIndex.get(), dIndex.get(), id);
                Storage.STORAGE.getIndexes().remove(dIndex.get());
                Thread.sleep(100);
            } else {
                this.checkIfMatrixDiagonalElIsNotZero();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void checkIfMatrixDiagonalElIsNotZero() {
        for (int i = 0; i < matrix.getRows(); i++) {
            if (matrix.getElement(i, i) == 0) {
                matrix.setElement(i, i, id);
            }
        }
    }

}
