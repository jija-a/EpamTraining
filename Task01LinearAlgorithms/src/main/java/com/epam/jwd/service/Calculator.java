package com.epam.jwd.service;

public interface Calculator {

    double geometricMean(double[] values);

    double geometricMeanFromLog(double[] logValues);

    double arithmeticMean(double[] values);

    double summation(double[] values);

    boolean isEvenNumber(double a);

    boolean isSumFirstTwoDigitEqualsSumLastTwoDigit(double a);

    boolean isXDigitNumber(double a, byte digitsInNumber);

    int sumOfDigits(int a);

    boolean sumOfAnyTwoDigitsEqualsThirdDigit(double a);

    boolean isOnePowerOfAnother(double n, double a);

    double calculateCFunction(double a);

    double numberInEightPowOnlyByMultiplying(double a);

    double numberInTenPowOnlyByMultiplying(double a);
}
