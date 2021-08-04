package com.epam.jwd.service.impl;

import com.epam.jwd.service.Calculator;

public class CalculatorImpl implements Calculator {

    public static final Calculator CALCULATOR = new CalculatorImpl();

    private CalculatorImpl() {
    }

    @Override
    public double geometricMean(double[] values) {
        double geometricMean;

        int size = values.length;

        double[] logValues = new double[size];
        for (int i = 0; i < size; i++) {
            logValues[i] = Math.log(values[i]);
        }

        geometricMean = this.geometricMeanFromLog(logValues);

        return geometricMean;
    }

    @Override
    public double geometricMeanFromLog(double[] logValues) {
        double logArithmeticMean = this.arithmeticMean(logValues);
        double geometricMean = Math.exp(logArithmeticMean);
        return geometricMean;
    }


    @Override
    public double arithmeticMean(double[] values) {
        double arithmeticMean;

        int size = values.length;
        double sum = this.summation(values);
        arithmeticMean = sum / size;

        return arithmeticMean;
    }


    @Override
    public double summation(double[] values) {
        double sum = 0.0;
        int size = values.length;

        for (int i = 0; i < size; i++) {
            sum += values[i];
        }

        return sum;
    }

}
