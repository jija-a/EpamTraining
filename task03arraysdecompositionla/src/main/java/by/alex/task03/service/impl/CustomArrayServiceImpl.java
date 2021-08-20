package by.alex.task03.service.impl;

import by.alex.task03.context.impl.ApplicationContextImpl;
import by.alex.task03.domain.CustomArray;
import by.alex.task03.service.CustomArrayService;
import by.alex.task03.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class CustomArrayServiceImpl implements CustomArrayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomArrayServiceImpl.class);

    @Override
    public Optional<CustomArray> findArrayById(Long id) {
        LOGGER.trace("Searching for array by id");

        return ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(CustomArray.class).stream()
                .filter(array -> array.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<CustomArray> findAllArrays() {
        LOGGER.trace("Searching for all arrays");

        return (List<CustomArray>) ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(CustomArray.class);
    }

    @Override
    public void bubbleSort(CustomArray customArray) {
        LOGGER.trace("Executing bubble sort");

        int size = customArray.getSize();
        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (customArray.getValue(j) > customArray.getValue(j + 1)) {
                    swap(customArray, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    @Override
    public void shakerSort(CustomArray customArray) {
        LOGGER.trace("Executing shaker sort");

        boolean swapped = true;
        int start = 0;
        int size = customArray.getSize();

        while (swapped) {
            swapped = false;
            for (int i = start; i < size - 1; ++i) {
                if (customArray.getValue(i) > customArray.getValue(i + 1)) {
                    swap(customArray, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            size--;
            for (int i = size - 1; i >= start; i--) {
                if (customArray.getValue(i) > customArray.getValue(i + 1)) {
                    swap(customArray, i, i + 1);
                    swapped = true;
                }
            }
            start++;
        }
    }

    @Override
    public void selectionSort(CustomArray customArray) {
        LOGGER.trace("Executing selection sort");

        int n = customArray.getSize();

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (customArray.getValue(j) < customArray.getValue(min))
                    min = j;

            swap(customArray, i, min);
        }
    }

    @Override
    public void insertionSort(CustomArray customArray) {
        LOGGER.trace("Executing insertion sort");

        int n = customArray.getSize();
        for (int i = 1; i < n; ++i) {
            double key = customArray.getValue(i);
            int j = i - 1;

            while (j >= 0 && customArray.getValue(j) > key) {
                customArray.setValue(j + 1, customArray.getValue(j));
                j = j - 1;
            }
            customArray.setValue(j + 1, key);
        }
    }

    @Override
    public void mergeSort(CustomArray customArray) {
        LOGGER.trace("Executing merge sort");

        mergesort(customArray, 0, customArray.getSize() - 1);
    }

    private static void mergesort(CustomArray customArray, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergesort(customArray, start, mid);
            mergesort(customArray, mid + 1, end);
        }
        int i = 0;
        int first = start;
        int last = mid + 1;
        double[] tmp = new double[end - start + 1];
        while (first <= mid && last <= end) {
            tmp[i++] = customArray.getValue(first) < customArray.getValue(last) ?
                    customArray.getValue(first++) : customArray.getValue(last++);
        }
        while (first <= mid) {
            tmp[i++] = customArray.getValue(first++);
        }
        while (last <= end) {
            tmp[i++] = customArray.getValue(last++);
        }
        i = 0;
        while (start <= end) {
            customArray.setValue(start++, tmp[i++]);
        }
    }

    @Override
    public void shellSort(CustomArray customArray) {
        LOGGER.trace("Executing Shell sort");

        int size = customArray.getSize();
        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i += 1) {
                double temp = customArray.getValue(i);
                int j;
                for (j = i; j >= gap && customArray.getValue(j - gap) > temp; j -= gap) {
                    customArray.setValue(j, customArray.getValue(j - gap));
                }
                customArray.setValue(j, temp);
            }
        }
    }

    @Override
    public void externalSort(CustomArray customArray) {
        LOGGER.trace("Executing external sort");

    }

    private void swap(CustomArray customArray, int firstPosition, int secondPosition) {
        double temp = customArray.getValue(firstPosition);
        customArray.setValue(firstPosition, customArray.getValue(secondPosition));
        customArray.setValue(secondPosition, temp);
    }

    @Override
    public void fillArray(CustomArray array, double[] values) {
        LOGGER.trace("Filling array with values");

        for (int i = 0; i < array.getSize(); i++) {
            array.setValue(i, values[i]);
        }
    }

    @Override
    public void fillArrayWithRandomValues(CustomArray array, int start, int end) {
        LOGGER.trace("Filling array with random values");

        for (int i = 0; i < array.getSize(); i++) {
            double value = Math.random() * (end - start) + start;
            array.setValue(i, value);
        }
    }

}
