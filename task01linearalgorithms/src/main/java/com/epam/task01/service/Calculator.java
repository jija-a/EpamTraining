package com.epam.task01.service;

public interface Calculator {

    double geometricMean(double[] values);

    double geometricMeanFromLog(double[] logValues);

    double arithmeticMean(double[] values);

    double summation(double[] values);

    boolean isEvenNumber(double a);

    boolean isSumFirstTwoDigitEqualsSumLastTwoDigit(double a);

    boolean isXDigitNumber(double number, int digitsInNumber);

    int sumOfDigits(int a);

    boolean sumOfAnyTwoDigitsEqualsThirdDigit(double a);

    boolean isOnePowerOfAnother(double n, double a);

    double calculateCFunction(double a);

    double numberInEightPowOnlyByMultiplying(double a);

    double numberInTenPowOnlyByMultiplying(double a);
}
