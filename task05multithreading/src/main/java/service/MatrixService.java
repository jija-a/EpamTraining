package service;

import domain.Matrix;

public interface MatrixService {

    Matrix readMatrix() throws ServiceException;

    void fillMatrixWithAtomicThread(Matrix matrix);

    void fillMatrixWithLockThread(Matrix matrix);

    void fillMatrixWithSetThread(Matrix matrix);

    void fillMatrixWithSemaphoreThread(Matrix matrix);
}
