package by.alex.task03.service.impl;

import by.alex.task03.context.impl.ApplicationContextImpl;
import by.alex.task03.domain.Matrix;
import by.alex.task03.domain.MatrixException;
import by.alex.task03.domain.factory.impl.MatrixFactoryImpl;
import by.alex.task03.service.MatrixService;
import by.alex.task03.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class MatrixServiceImpl implements MatrixService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixServiceImpl.class);

    @Override
    public Optional<Matrix> findMatrixById(Long id) {
        return ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Matrix.class).stream()
                .filter(matrix -> matrix.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Matrix> findAllMatrix() {
        return (List<Matrix>) ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Matrix.class);
    }

    @Override
    public void fillRandomized(Matrix matrix, int start, int end) throws ServiceException {
        int rows = matrix.getRows();
        int columns = matrix.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    double value = Math.random() * (end - start) + start;
                    matrix.setElement(i, j, value);
                } catch (MatrixException e) {
                    throw new ServiceException(e);
                }
            }
        }
    }

    @Override
    public void fillMatrixWithValues(Matrix matrix, double[][] values) throws ServiceException {
        int rows = matrix.getRows();
        int columns = matrix.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    double value = values[i][j];
                    matrix.setElement(i, j, value);
                } catch (MatrixException e) {
                    throw new ServiceException(e);
                }
            }
        }
    }

    @Override
    public Matrix multiply(Matrix firstMatrix, Matrix secondMatrix)
            throws ServiceException, IllegalArgumentException {

        if (firstMatrix.getColumns() != secondMatrix.getRows()) {
            throw new IllegalArgumentException("Incompatible range of matrix");
        }
        try {
            int rows = firstMatrix.getRows();
            int columns = secondMatrix.getColumns();
            Matrix resultMatrix = MatrixFactoryImpl.ENTITY_FACTORY.create(rows, columns);

            double[][] resultMatrixValues = new double[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    for (int k = 0; k < firstMatrix.getColumns(); k++) {
                        resultMatrixValues[i][j] += firstMatrix.getElement(i, k) * secondMatrix.getElement(k, j);
                        resultMatrix.setElement(i, j, resultMatrixValues[i][j]);
                    }
                }
            }
            return resultMatrix;
        } catch (MatrixException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Matrix sum(Matrix firstMatrix, Matrix secondMatrix)
            throws ServiceException, IllegalArgumentException {

        if (firstMatrix.getColumns() != secondMatrix.getColumns()
                || firstMatrix.getRows() != secondMatrix.getRows()) {
            throw new IllegalArgumentException("Incompatible range of matrix");
        }
        try {
            int rows = firstMatrix.getRows();
            int columns = firstMatrix.getColumns();
            Matrix resultMatrix = MatrixFactoryImpl.ENTITY_FACTORY.create(rows, columns);

            double[][] resultMatrixValues = new double[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    resultMatrixValues[i][j] = firstMatrix.getElement(i, j) + secondMatrix.getElement(i, j);
                    resultMatrix.setElement(i, j, resultMatrixValues[i][j]);
                }
            }
            return resultMatrix;
        } catch (MatrixException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Matrix subtract(Matrix firstMatrix, Matrix secondMatrix)
            throws ServiceException, IllegalArgumentException {

        if (firstMatrix.getColumns() != secondMatrix.getColumns()
                || firstMatrix.getRows() != secondMatrix.getRows()) {
            throw new IllegalArgumentException("Incompatible range of matrix");
        }
        try {
            int rows = firstMatrix.getRows();
            int columns = firstMatrix.getColumns();
            Matrix resultMatrix = MatrixFactoryImpl.ENTITY_FACTORY.create(rows, columns);

            double[][] resultMatrixValues = new double[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    resultMatrixValues[i][j] = firstMatrix.getElement(i, j) - secondMatrix.getElement(i, j);
                    resultMatrix.setElement(i, j, resultMatrixValues[i][j]);
                }
            }
            return resultMatrix;
        } catch (MatrixException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Matrix transpose(Matrix matrix) throws ServiceException {

        Matrix resultMatrix = MatrixFactoryImpl.ENTITY_FACTORY.create(matrix.getColumns(), matrix.getRows());

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                try {
                    resultMatrix.setElement(j, i, matrix.getElement(i, j));
                } catch (MatrixException e) {
                    throw new ServiceException(e);
                }
            }
        }

        return resultMatrix;
    }

}
