package service.impl;

import dao.BaseFileReader;
import dao.EntityParser;
import dao.impl.BaseFileReaderImpl;
import dao.impl.LimitParserImpl;
import dao.impl.MatrixParserImpl;
import dao.impl.MatrixValuesParserImpl;
import domain.Limit;
import domain.Matrix;
import service.*;
import service.factory.WrongArgumentsException;
import service.validator.MatrixValidator;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MatrixServiceImpl implements MatrixService {

    private final BaseFileReader fileReader;
    private final EntityParser<Matrix> matrixParser;
    private final EntityParser<Limit> limitParser;
    private final EntityParser valuesParser;

    public MatrixServiceImpl() {
        this.fileReader = new BaseFileReaderImpl();
        this.limitParser = new LimitParserImpl();
        this.matrixParser = new MatrixParserImpl();
        this.valuesParser = new MatrixValuesParserImpl();
    }

    @Override
    public Matrix readMatrix() throws ServiceException {

        try {
            String matrixFileName = fileReader.read(ApplicationConfig.CONFIG.getMatrixFilePath());
            Matrix matrix = matrixParser.parse(matrixFileName);
            Limit limit = limitParser.parse(matrixFileName);

            if (MatrixValidator.validateLimit(matrix.getColumns(), limit)) {
                double[][] values = (double[][]) valuesParser.parse(matrixFileName);
                this.fillMatrixWithValues(matrix, values);
                return matrix;
            } else {
                throw new ServiceException("Matrix did not pass limit validation");
            }
        } catch (IOException | InitializingException | WrongArgumentsException e) {
            throw new ServiceException("Exception provided by dao: ", e);
        }
    }

    @Override
    public void fillMatrixWithCountdownThread(Matrix matrix) {

        ArrayList<Integer> permits = new ArrayList<>();
        this.initArrayList(matrix.getRows(), permits);

        CountDownLatch latch = new CountDownLatch(matrix.getColumns());
        for (int i = 0; i < matrix.getColumns(); i++) {
            new Thread(new MatrixCountdownFillThread(matrix, latch, getNumber(permits))).start();
        }

        try {
            latch.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.initArrayList(matrix.getRows(), permits);
    }

    @Override
    public void fillMatrixWithLockThread(Matrix matrix) {

        List<Thread> threads = new ArrayList<>();
        this.fillStorage(matrix);

        for (int i = 1; i <= matrix.getRows(); i++) {
            threads.add(new Thread(new MatrixLockFillThread(i, matrix)));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        this.fillStorage(matrix);
    }

    @Override
    public void fillMatrixWithPhaseThread(Matrix matrix) {
        //todo
        /*Phaser phaser = new Phaser(1);
        new Thread(new MatrixPhaseFillThread(phaser, "PhaseThread 1")).start();
        new Thread(new MatrixPhaseFillThread(phaser, "PhaseThread 2")).start();

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");
        // ждем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();*/
    }

    @Override
    public void fillMatrixWithSemaphoreThread(Matrix matrix) {
        //todo
        /*Semaphore sem = new Semaphore(1, false); // 1 разрешение, беспорядочно
        CommonResource res = new CommonResource();
        new Thread(new CountThread(res, sem, "CountThread 1")).start();
        new Thread(new CountThread(res, sem, "CountThread 2")).start();
        new Thread(new CountThread(res, sem, "CountThread 3")).start();
        new Thread(new CountThread(res, sem, "CountThread 4")).start();
        new Thread(new CountThread(res, sem, "CountThread 5")).start();
        new Thread(new CountThread(res, sem, "CountThread 6")).start();
        new Thread(new CountThread(res, sem, "CountThread 7")).start();
        new Thread(new CountThread(res, sem, "CountThread 8")).start();
        new Thread(new CountThread(res, sem, "CountThread 9")).start();
        new Thread(new CountThread(res, sem, "CountThread 10")).start();*/
    }

    private void fillMatrixWithValues(Matrix matrix, double[][] values) {
        for (int i = 0; i < matrix.getColumns(); i++) {
            for (int j = 0; j < matrix.getRows(); j++) {
                matrix.setElement(i, j, values[i][j]);
            }
        }
    }

    private void initArrayList(int size, List<Integer> permits) {
        for (int i = 0; i < size; i++) {
            permits.add(i);
        }
    }

    private int getNumber(List<Integer> permits) {
        if (!permits.isEmpty()) {
            Collections.shuffle(permits);
            int temp = permits.get(0);
            permits.remove(0);
            return temp;
        }
        throw new RuntimeException();
    }

    private void fillStorage(Matrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            Storage.STORAGE.getIndexes().add(i);
        }
    }

}
