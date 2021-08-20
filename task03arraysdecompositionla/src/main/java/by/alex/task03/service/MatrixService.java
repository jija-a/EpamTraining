package by.alex.task03.service;

import by.alex.task03.domain.Matrix;

import java.util.List;
import java.util.Optional;

public interface MatrixService {

    Optional<Matrix> findMatrixById(Long id);

    List<Matrix> findAllMatrix();

    void fillRandomized(Matrix matrix, int start, int end) throws ServiceException;

    void fillMatrixWithValues(Matrix matrix, double[][] values) throws ServiceException;

    Matrix multiply(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException, IllegalArgumentException;

    Matrix sum(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException, IllegalArgumentException;

    Matrix subtract(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException, IllegalArgumentException;

    Matrix transpose(Matrix matrix) throws ServiceException;

}
