package service;

import domain.Matrix;

public interface MatrixService {

    Matrix readMatrix() throws ServiceException;

    void fillMatrixWithCountdownThread();

    void fillMatrixWithLockThread();

    void fillMatrixWithPhaseThread();

    void fillMatrixWithSemaphoreThread();
}
