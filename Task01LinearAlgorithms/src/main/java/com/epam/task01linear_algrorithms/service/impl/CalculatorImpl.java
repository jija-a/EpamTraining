package com.epam.task01linear_algrorithms.service.impl;

import com.epam.task01linear_algrorithms.service.Calculator;

public class CalculatorImpl implements Calculator {

    private static final int C_FUNCTION_CONSTANT = 3;
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
    public boolean isXDigitNumber(double number, int digitsInNumber) {
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number = Math.round(number / 10);
        }
        return count == digitsInNumber;
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
    public boolean sumOfAnyTwoDigitsEqualsThirdDigit(double a) {
        int firstDigit = (int) (a % 10);
        int secondDigit = (int) (a / 10 % 10);
        int thirdDigit = (int) (a / 100);

        return firstDigit + secondDigit == thirdDigit
                || firstDigit + thirdDigit == secondDigit
                || thirdDigit + secondDigit == firstDigit;
    }

    @Override
    public boolean isOnePowerOfAnother(double n, double a) {
        return (n == 1) || (n == a) || (n == a * a) || (n == Math.pow(a, 3)) || (n == Math.pow(a, 4));
    }

    @Override
    public double calculateCFunction(double a) {
        return C_FUNCTION_CONSTANT + a;
    }

    @Override
    public double numberInEightPowOnlyByMultiplying(double a) {
        double b = a * a;
        double c = b * b;
        return c * c;
    }

    @Override
    public double numberInTenPowOnlyByMultiplying(double a) {
        return numberInEightPowOnlyByMultiplying(a) * a * a;
    }

}
