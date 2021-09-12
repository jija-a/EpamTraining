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

            if (MatrixValidator.validateLimit(matrix, limit)) {
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
    public void fillMatrixWithCountdownThread() {
        new Thread(new MatrixCountdownFillThread()).start();
    }

    @Override
    public void fillMatrixWithLockThread() {
        new Thread(new MatrixLockFillThread()).start();
    }

    @Override
    public void fillMatrixWithPhaseThread() {
        new Thread(new MatrixPhaseFillThread()).start();
    }

    @Override
    public void fillMatrixWithSemaphoreThread() {
        new Thread(new MatrixSemaphoreFillThread()).start();
    }

    private void fillMatrixWithValues(Matrix matrix, double[][] values) {
        for (int i = 0; i < matrix.getColumns(); i++) {
            for (int j = 0; j < matrix.getRows(); j++) {
                matrix.setElement(i, j, values[i][j]);
            }
        }
    }

}
