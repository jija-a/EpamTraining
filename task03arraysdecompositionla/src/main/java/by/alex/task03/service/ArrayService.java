package by.alex.task03.service;

import by.alex.task03.domain.Array;
import by.alex.task03.exception.ServiceException;

public interface ArrayService {

    double[] generateRandomArray() throws ServiceException;

    Array createArray(Object... args) throws ServiceException;

    Array bubbleSort(Array array) throws ServiceException;

    Array shakerSort(Array array) throws ServiceException;

    Array selectionSort(Array array) throws ServiceException;

    Array insertionHashSort(Array array) throws ServiceException;

    Array insertionSimpleSort(Array array) throws ServiceException;

    Array binaryMergeSort(Array array) throws ServiceException;

    Array shellSort(Array array) throws ServiceException;

    Array externalSort(Array array) throws ServiceException;

}
