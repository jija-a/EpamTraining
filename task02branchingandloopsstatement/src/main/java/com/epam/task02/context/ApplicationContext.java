package com.epam.task02.context;

import com.epam.task02.exception.InvalidStateException;

import java.util.List;

public interface ApplicationContext {

    List<Double> retrieveNumbers();

    void init() throws InvalidStateException;

}
