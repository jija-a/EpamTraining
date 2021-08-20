package by.alex.task03.service;

import by.alex.task03.domain.Matrix;

import java.util.List;
import java.util.Optional;

public interface MatrixService {

    Optional<Matrix> findMatrixById(Long id);

    List<Matrix> findAllMatrix();

    void fillRandomized(Matrix matrix, int start, int end);

    void fillMatrixWithValues(Matrix matrix, double[][] values);

    Matrix multiply(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException;

    Matrix sum(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException;

    Matrix subtract(Matrix firstMatrix, Matrix secondMatrix) throws ServiceException;

    Matrix transpose(Matrix matrix);

}
