package by.alex.task03.service;

import by.alex.task03.domain.Matrix;
import by.alex.task03.domain.MatrixException;

import java.util.List;

public interface MatrixService {

    void fillRandomized(Matrix matrix, int start, int end) throws ServiceException;

    void fillFromFile(Matrix matrix, List<Integer> values) throws ServiceException;

    Matrix createMatrix(Object... args) throws ServiceException;


}
