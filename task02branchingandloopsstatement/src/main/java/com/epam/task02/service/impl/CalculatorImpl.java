package com.epam.task02.service.impl;

import com.epam.task02.Main;
import com.epam.task02.service.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl implements Calculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorImpl.class);
    public static final Calculator CALCULATOR = new CalculatorImpl();

    @Override
    public double calculateBranchingFunction(double x) {
        LOGGER.trace("calculating branching function");
        double result;

        if (x >= 3) {
            result = -x * x + 3 * x + 9;
        } else {
            result = 1 / (Math.pow(x, 3) - 6);
        }

        return result;
    }

    @Override
    public String isOneMoreThanAnother(double a, double b) {
        LOGGER.trace("calculating one more than another function");
        String result;

        if (a > b) {
            result = "yes";
        } else {
            result = "no";
        }

        return result;
    }

    @Override
    public double calculateCycleFunction(double a, double n) {
        LOGGER.trace("calculating cycle function");
        double product = 1;

        for (int i = 0; i < n; i++) {
            product *= (a + i);
        }

        return product;
    }

    @Override
    public List<Double> getDecreasingRow(double from, double to) {
        LOGGER.trace("getting decreasing row");
        List<Double> row = new ArrayList<>();

        for (double i = to; i >= from; i--) {
            row.add(i);
        }

        return row;
    }

    @Override
    public List<Integer> getDividers(double a, double b) {
        LOGGER.trace("getting dividers");
        List<Integer> dividers = new ArrayList<>();
        while (a <= b) {
            for (int i = 2; i < a - 1; i++) {
                if (a % i == 0) {
                    dividers.add(i);
                }
            }
            a = a + 1;
        }

        return dividers;
    }

    @Override
    public double findMax(double a, double b) {
        LOGGER.trace("searching for max function");
        double max;

        if (a < b) {
            max = b;
        } else {
            max = a;
        }

        return max;
    }

    @Override
    public double findMin(double a, double b) {
        LOGGER.trace("searching for min function");
        double min;

        if (a < b) {
            min = a;
        } else {
            min = b;
        }

        return min;
    }

    @Override
    public List<Double> powValues(List<Double> values) {
        LOGGER.trace("pow values function");
        List<Double> newValues = new ArrayList<>();
        for (double value : values) {
            if (value > -1) {
                value = value * value;
            } else {
                value = Math.pow(value, 4);
            }
            newValues.add(value);
        }

        return newValues;
    }

    @Override
    public double[] resolveProblem() {
        LOGGER.trace("resolving problem function");
        double a = 0;
        double b = 0;

        for (int i = 10; i <= 99; i++) {
            for (int j = 10; j <= 99; j++) {
                if (((((i * 100) + j) % 99) == 0) && ((((j * 100) + i) % 49) == 0)) {
                    a = i;
                    b = j;
                }
            }
        }

        return new double[]{a, b};
    }

    @Override
    public double[] replaceOneAnother(double a, double b) {
        LOGGER.trace("replacing one another function");
        if (a == b) {
            a = 0;
            b = 0;
        } else {
            if (a > b) {
                b = a;
            } else {
                a = b;
            }
        }

        return new double[]{a, b};
    }

    @Override
    public double findSubsequenceProduct(double a) {
        LOGGER.trace("searching subsequence product function");
        double product = 1;

        for (int i = 2; i < 10; i++) {
            a = 6 + a;
            product *= a;
        }

        return product;
    }

}
