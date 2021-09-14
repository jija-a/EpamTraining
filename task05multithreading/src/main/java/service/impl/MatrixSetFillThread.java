package service.impl;

import domain.Matrix;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MatrixSetFillThread implements Runnable {

    private final int id;
    private final Matrix matrix;
    private final AtomicBoolean isDone = new AtomicBoolean();
    private final ConcurrentSkipListSet<Integer> skipListSet;

    public MatrixSetFillThread(int id, Matrix matrix, ConcurrentSkipListSet<Integer> skipListSet) {
        this.id = id;
        this.matrix = matrix;
        this.skipListSet = skipListSet;
    }

    @Override
    public void run() {

        try {
            if (!isDone.get()) {
                int size = matrix.getRows();
                int index = skipListSet.size();
                if (index < size) {
                    if (skipListSet.add(index)) {
                        matrix.setElement(index, index, id);
                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                } else {
                    isDone.set(true);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

}