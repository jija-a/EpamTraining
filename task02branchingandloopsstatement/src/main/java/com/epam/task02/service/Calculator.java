package com.epam.task02.service;

import java.util.List;

public interface Calculator {

    double calculateBranchingFunction(double x);

    String isOneMoreThanAnother(double a, double b);

    double calculateCycleFunction(double a, double n);

    List<Double> getDecreasingRow(double from, double to);

    List<Integer> getDividers(double a, double b);

    double findMax(double a, double b);

    double findMin(double a, double c);

    List<Double> powValues(List<Double> values);

    double[] resolveProblem();

    double[] replaceOneAnother(double a, double b);

    double findSubsequenceProduct(double a);

}
