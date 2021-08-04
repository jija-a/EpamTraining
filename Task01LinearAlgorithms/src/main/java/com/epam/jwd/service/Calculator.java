package com.epam.jwd.service;

public interface Calculator {

    double geometricMean(double[] values);

    double geometricMeanFromLog(double[] logValues);

    double arithmeticMean(double[] values);

    double summation(double[] values);

}
