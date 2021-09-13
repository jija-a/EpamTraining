package service.impl;

import domain.Matrix;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class MatrixCountdownFillThread implements Runnable {
    private static final AtomicInteger COUNTER = new AtomicInteger(1);
    private final CountDownLatch latch;
    private final int threadId;
    private final int dElem;
    private final Matrix matrix;

    public MatrixCountdownFillThread(Matrix matrix, CountDownLatch latch, int dElem) {
        this.latch = latch;
        threadId = COUNTER.getAndIncrement();
        this.dElem = dElem;
        this.matrix = matrix;
    }

    @Override
    public void run() {
        fillDiagonalElement(matrix, dElem, threadId);
        latch.countDown();
    }

    public void fillDiagonalElement(Matrix matrix, int index, int element) {
        matrix.setElement(index, index, element);
    }

}
