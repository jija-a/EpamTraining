package by.alex.task03.service.impl;

import by.alex.task03.domain.Array;
import by.alex.task03.factory.impl.ArrayFactory;
import by.alex.task03.service.ArrayService;
import by.alex.task03.exception.ServiceException;

public class ArrayServiceImpl implements ArrayService {

    @Override
    public double[] generateRandomArray() throws ServiceException {
        int min = 1;
        int max = 50;
        int arraySize = (int) (Math.random() * (max - min) + min);
        double[] arr = new double[arraySize];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * (max - min) + min;
        }
        return arr;
    }

    @Override
    public Array createArray(Object... args) throws ServiceException {

        if ((args.length != 1) && (args[0].getClass().isInstance(Number.class))) {
            throw new ServiceException();
        }

        return ArrayFactory.ARRAY_FACTORY.create(args);
    }

    @Override
    public Array bubbleSort(Array array) throws ServiceException {
        return null;
    }

    @Override
    public Array shakerSort(Array array) throws ServiceException {
        return null;
    }

    @Override
    public Array selectionSort(Array array) throws ServiceException {
        return null;
    }

    @Override
    public Array insertionHashSort(Array array) throws ServiceException {
        return null;
    }

    @Override
    public Array insertionSimpleSort(Array array) throws ServiceException {
        return null;
    }

    @Override
    public Array binaryMergeSort(Array array) throws ServiceException {
        return null;
    }

    @Override
    public Array shellSort(Array array) throws ServiceException {
        return null;
    }

    @Override
    public Array externalSort(Array array) throws ServiceException {
        return null;
    }

}
