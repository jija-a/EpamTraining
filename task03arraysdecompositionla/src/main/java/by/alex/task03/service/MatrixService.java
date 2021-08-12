package by.alex.task03.service;

import by.alex.task03.domain.Matrix;
import by.alex.task03.exception.ServiceException;

public interface MatrixService {

    void fillRandomized(Matrix matrix, int start, int end) throws ServiceException;

    void fillMatrixWithValues(Matrix matrix, double[][] values) throws ServiceException;

    Matrix createMatrix(Object... args) throws ServiceException;

    Matrix multiply(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException;

    Matrix divide(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException;

    Matrix sum(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException;

    Matrix subtract(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException;

    Matrix transpose(Matrix matrix) throws ServiceException;

}
