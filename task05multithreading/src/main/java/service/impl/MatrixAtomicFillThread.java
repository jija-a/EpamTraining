package service.impl;

import domain.Matrix;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MatrixAtomicFillThread implements Runnable {

    private final AtomicInteger lastIndex = new AtomicInteger(0);
    private final int id;
    private final Matrix matrix;
    private final AtomicBoolean isDone = new AtomicBoolean(false);

    public MatrixAtomicFillThread(int id, Matrix matrix) {
        this.id = id;
        this.matrix = matrix;
    }

    @Override
    public void run() {

        if (!isDone.get()) {
            int index = 0;
            while (index != -1 && !isDone.get()) {
                index = findEmptyIndex();
                if (index != -1) {
                    matrix.setElement(index, index, id);
                    lastIndex.incrementAndGet();
                }
            }
            isDone.set(true);
        }
    }

    private int findEmptyIndex() {
        for (int i = lastIndex.get(); i < matrix.getRows(); i++) {
            if (matrix.getElement(i, i) == 0) {
                return i;
            }
        }
        return -1;
    }

}
