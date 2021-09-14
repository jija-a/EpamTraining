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
import java.util.concurrent.*;

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
    public void fillMatrixWithAtomicThread(Matrix matrix) {

        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= matrix.getRows(); i++) {
            threads.add(new Thread(new MatrixAtomicFillThread(i, matrix)));
        }
        this.startThreads(threads);
        this.joinThreads(threads);
    }

    @Override
    public void fillMatrixWithLockThread(Matrix matrix) {

        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= matrix.getRows(); i++) {
            threads.add(new Thread(new MatrixLockFillThread(i, matrix)));
        }
        this.startThreads(threads);
        this.joinThreads(threads);
     }

    @Override
    public void fillMatrixWithSetThread(Matrix matrix) {

        ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= matrix.getRows(); i++) {
            threads.add(new Thread(new MatrixSetFillThread(i, matrix, skipListSet)));
        }
        this.startThreads(threads);
        this.joinThreads(threads);
    }

    @Override
    public void fillMatrixWithSemaphoreThread(Matrix matrix) {

        List<Thread> threads = new ArrayList<>();
        Semaphore semaphore =  new Semaphore(1);
        for (int i = 1; i <= matrix.getRows(); i++) {
            threads.add(new Thread(new MatrixSemaphoreFillThread(i, matrix, semaphore)));
        }
        this.startThreads(threads);
        this.joinThreads(threads);
    }

    private void fillMatrixWithValues(Matrix matrix, double[][] values) {
        for (int i = 0; i < matrix.getColumns(); i++) {
            for (int j = 0; j < matrix.getRows(); j++) {
                matrix.setElement(i, j, values[i][j]);
            }
        }
    }

    private void startThreads(List<Thread> threads) {
        threads.forEach(Thread::start);
    }

    private void joinThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
