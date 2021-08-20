package by.alex.task03.service.impl;

import by.alex.task03.context.impl.ApplicationContextImpl;
import by.alex.task03.domain.Matrix;
import by.alex.task03.domain.factory.impl.MatrixFactoryImpl;
import by.alex.task03.service.MatrixService;
import by.alex.task03.service.ServiceException;
import by.alex.task03.validator.MatrixValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class MatrixServiceImpl implements MatrixService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixServiceImpl.class);
    private final MatrixValidator validator;

    public MatrixServiceImpl() {
        this.validator = new MatrixValidator();
    }

    @Override
    public Optional<Matrix> findMatrixById(Long id) {
        LOGGER.trace("Searching for matrix by id");

        return ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Matrix.class).stream()
                .filter(matrix -> matrix.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Matrix> findAllMatrix() {
        LOGGER.trace("Searching for all matrices");

        return (List<Matrix>) ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Matrix.class);
    }

    @Override
    public void fillRandomized(Matrix matrix, int start, int end) {
        LOGGER.trace("Filling matrix with random values");

        int rows = matrix.getRows();
        int columns = matrix.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double value = Math.random() * (end - start) + start;
                matrix.setElement(i, j, value);
            }
        }
    }

    @Override
    public void fillMatrixWithValues(Matrix matrix, double[][] values) {
        LOGGER.trace("Filling matrix with given values");

        int rows = matrix.getRows();
        int columns = matrix.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double value = values[i][j];
                matrix.setElement(i, j, value);
            }
        }
    }

    @Override
    public Matrix multiply(Matrix firstMatrix, Matrix secondMatrix)
            throws ServiceException {
        LOGGER.trace("Multiplying matrices");

        if (!validator.isValidMatricesForMultiplying(firstMatrix, secondMatrix)) {
            throw new ServiceException("Incompatible range of matrix");
        }
        int rows = firstMatrix.getRows();
        int columns = secondMatrix.getColumns();

        double[][] resultMatrixValues = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < firstMatrix.getColumns(); k++) {
                    resultMatrixValues[i][j] += firstMatrix.getElement(i, k) * secondMatrix.getElement(k, j);
                }
            }
        }
        return this.createAndFillMatrix(rows, columns, resultMatrixValues);
    }

    @Override
    public Matrix sum(Matrix firstMatrix, Matrix secondMatrix)
            throws ServiceException {
        LOGGER.trace("Sum matrices");

        if (!validator.isValidMatricesForSumOrSubtract(firstMatrix, secondMatrix)) {
            throw new ServiceException("Incompatible range of matrix");
        }
        int rows = firstMatrix.getRows();
        int columns = firstMatrix.getColumns();

        double[][] resultMatrixValues = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrixValues[i][j] = firstMatrix.getElement(i, j) + secondMatrix.getElement(i, j);
            }
        }
        return this.createAndFillMatrix(rows, columns, resultMatrixValues);
    }

    @Override
    public Matrix subtract(Matrix firstMatrix, Matrix secondMatrix)
            throws ServiceException {
        LOGGER.trace("Subtracting matrices");

        if (validator.isValidMatricesForSumOrSubtract(firstMatrix, secondMatrix)) {
            throw new ServiceException("Incompatible range of matrix");
        }
        int rows = firstMatrix.getRows();
        int columns = firstMatrix.getColumns();

        double[][] resultMatrixValues = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrixValues[i][j] = firstMatrix.getElement(i, j) - secondMatrix.getElement(i, j);
            }
        }
        return this.createAndFillMatrix(rows, columns, resultMatrixValues);
    }

    @Override
    public Matrix transpose(Matrix matrix) {
        LOGGER.trace("Transposing matrix");

        Matrix resultMatrix = MatrixFactoryImpl.ENTITY_FACTORY.create(matrix.getColumns(), matrix.getRows());
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                resultMatrix.setElement(j, i, matrix.getElement(i, j));
            }
        }

        return resultMatrix;
    }

    private Matrix createAndFillMatrix(int rows, int columns, double[][] values) {
        Matrix resultMatrix = MatrixFactoryImpl.ENTITY_FACTORY.create(rows, columns);
        this.fillMatrixWithValues(resultMatrix, values);
        return resultMatrix;
    }

}
