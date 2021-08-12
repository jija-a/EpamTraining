package by.alex.task03.service.impl;

import by.alex.task03.domain.Matrix;
import by.alex.task03.exception.MatrixException;
import by.alex.task03.factory.impl.MatrixFactory;
import by.alex.task03.service.MatrixService;
import by.alex.task03.exception.ServiceException;

public class MatrixServiceImpl implements MatrixService {

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
                    throw new ServiceException(e.getMessage());
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
                    e.printStackTrace();
                    throw new ServiceException(e.getMessage());
                }
            }
        }
    }

    @Override
    public Matrix createMatrix(Object... args) throws ServiceException {

        if (!compatibleArguments(args)) {
            throw new ServiceException("Incompatible arguments for creating matrix");
        }

        return MatrixFactory.MATRIX_FACTORY.create(args);

    }

    private boolean compatibleArguments(Object... args) {
        if (args.length != 2) {
            return false;
        }

        int rows = (int) args[0];
        int columns = (int) args[1];

        return (rows >= 1) && (columns >= 1);
    }

    @Override
    public Matrix multiply(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException {
        try {
            return this.doOperation(firstMatrix, secondMatrix, ArithmeticAction.MULTIPLY);
        } catch (MatrixException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Matrix divide(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException {
        try {
            return this.doOperation(firstMatrix, secondMatrix, ArithmeticAction.DIVISION);
        } catch (MatrixException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Matrix sum(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException {
        try {
            return this.doOperation(firstMatrix, secondMatrix, ArithmeticAction.SUM);
        } catch (MatrixException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Matrix subtract(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException {
        try {
            return this.doOperation(firstMatrix, secondMatrix, ArithmeticAction.SUBTRACT);
        } catch (MatrixException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Matrix transpose(Matrix matrix) throws ServiceException {
        Matrix resultMatrix = new Matrix(matrix.getRows(), matrix.getColumns());

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                try {
                    resultMatrix.setElement(j, i, matrix.getElement(i, j));
                } catch (MatrixException e) {
                    throw new ServiceException();
                }
            }
        }

        return resultMatrix;
    }

    private Matrix doOperation(Matrix firstMatrix, Matrix secondMatrix, ArithmeticAction action)
            throws MatrixException {

        int rows = firstMatrix.getRows();
        int columns = firstMatrix.getColumns();
        Matrix resultMatrix = new Matrix(rows, columns);

        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    result[i][j] = this.resolveAction(firstMatrix.getElement(i, j), secondMatrix.getElement(i, j), action);
                    resultMatrix.setElement(i, j, result[i][j]);
                } catch (MatrixException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultMatrix;
    }

    private double resolveAction(double firstNum, double secondNum, ArithmeticAction action) {
        double result;

        if (action.equals(ArithmeticAction.DIVISION)) {
            result = firstNum / secondNum;
        } else if (action.equals(ArithmeticAction.MULTIPLY)) {
            result = firstNum * secondNum;
        } else if (action.equals(ArithmeticAction.SUM)) {
            result = firstNum + secondNum;
        } else if (action.equals(ArithmeticAction.SUBTRACT)) {
            result = firstNum - secondNum;
        } else {
            throw new ServiceException();
        }

        return result;
    }

}
