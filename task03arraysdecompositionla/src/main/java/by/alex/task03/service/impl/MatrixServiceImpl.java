package by.alex.task03.service.impl;

import by.alex.task03.domain.Matrix;
import by.alex.task03.domain.MatrixException;
import by.alex.task03.factory.impl.MatrixFactory;
import by.alex.task03.service.MatrixService;
import by.alex.task03.service.ServiceException;

import java.util.List;

public class MatrixServiceImpl implements MatrixService {

    @Override
    public void fillRandomized(Matrix matrix, int start, int end) throws ServiceException {
        int rows = matrix.getRows();
        int columns = matrix.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    int value = (int) (Math.random() * (end - start) + start);
                    matrix.setElement(i, j, value);
                } catch (MatrixException e) {
                    throw new ServiceException(e.getMessage());
                }
            }
        }
    }

    @Override
    public void fillFromFile(Matrix matrix, List<Integer> values) throws ServiceException {
        int rows = matrix.getRows();
        int columns = matrix.getColumns();

        int matrixSize = rows * columns;
        if (values.size() != matrixSize) {
            throw new ServiceException("Incompatible matrix size");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    int value = values.get(i + j);
                    matrix.setElement(i, j, value);
                } catch (MatrixException e) {
                    e.printStackTrace();
                    throw new ServiceException(e.getMessage());
                }
            }
        }
    }

    @Override
    public Matrix createMatrix(Object... args) throws ServiceException {
        Matrix matrix;

        try {
            matrix = MatrixFactory.MATRIX_FACTORY.create(args);
        } catch (MatrixException e) {
            throw new ServiceException(e.getMessage());
        }

        return matrix;
    }

}
