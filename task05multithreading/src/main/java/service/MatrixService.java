package service;

import domain.Matrix;

public interface MatrixService {

    Matrix readMatrix() throws ServiceException;

    void fillMatrixWithCountdownThread(Matrix matrix);

    void fillMatrixWithLockThread(Matrix matrix);

    void fillMatrixWithPhaseThread(Matrix matrix);

    void fillMatrixWithSemaphoreThread(Matrix matrix);
}
