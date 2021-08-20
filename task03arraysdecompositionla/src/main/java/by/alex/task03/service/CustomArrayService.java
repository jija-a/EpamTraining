package by.alex.task03.service;

import by.alex.task03.domain.CustomArray;

import java.util.List;
import java.util.Optional;

public interface CustomArrayService {

    Optional<CustomArray> findArrayById(Long id);

    List<CustomArray> findAllArrays();

    void bubbleSort(CustomArray customArray);

    void shakerSort(CustomArray customArray);

    void selectionSort(CustomArray customArray);

    void insertionSort(CustomArray customArray);

    void mergeSort(CustomArray customArray);

    void shellSort(CustomArray customArray);

    void externalSort(CustomArray customArray);

    void fillArray(CustomArray array, double[] values) throws ServiceException;

    void fillArrayWithRandomValues(CustomArray array, int start, int end);

}
