package by.alex.task03.service;

import java.util.List;

public interface ArrayService {

    double[] fillRandomized() throws ServiceException;

    double[] fillFromFile(List<Integer> values) throws ServiceException;

    double[] createArray(Object... args) throws ServiceException;

}
