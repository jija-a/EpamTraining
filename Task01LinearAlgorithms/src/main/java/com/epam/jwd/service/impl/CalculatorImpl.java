package com.epam.jwd.service.impl;

import com.epam.jwd.domain.Triangle;
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


    @Override
    public boolean isEvenNumber(double a) {
        return a % 2 == 0;
    }

    @Override
    public boolean isSumFirstTwoDigitEqualsSumLastTwoDigit(double a) {
        return (Math.round(a / 1000) + Math.round((a / 100) % 10) == Math.round((a % 100) / 10) + Math.round(a % 10));
    }

    @Override
    public boolean isXDigitNumber(double a, byte digitsInNumber) {
        return a > Math.pow(10, digitsInNumber - 1) - 1 && a < Math.pow(10, digitsInNumber);
    }

    @Override
    public int sumOfDigits(int a) {
        int sum = 0;

        while (a != 0) {
            sum = sum + a % 10;
            a = a / 10;
        }

        return sum;
    }

    @Override
    public boolean triangleIsIsosceles(Triangle triangle) {
        return (triangle.getA() == triangle.getB() && triangle.getA() != triangle.getC())
                || (triangle.getA() == triangle.getC() && triangle.getA() != triangle.getB())
                || (triangle.getB() == triangle.getC() && triangle.getB() != triangle.getA());
    }

    @Override
    public boolean sumOfAnyTwoDigitsEqualsThirdDigit(double a) {
        double newA = a;
        double firstDigit = newA % 10;
        newA = newA / 10;
        double secondDigit = newA % 10;
        newA = newA / 10;
        double thirdDigit = newA % 10;

        return firstDigit + secondDigit == thirdDigit
                || firstDigit + thirdDigit == secondDigit
                || thirdDigit + secondDigit == firstDigit;
    }

    @Override
    public boolean isOnePowerOfAnother(double n, double a) {
        return (n == 1) || (n == a) || (n == a * a) || (n == Math.pow(a, 3)) || (n == Math.pow(a, 4));
    }

}
