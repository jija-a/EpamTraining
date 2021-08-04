package com.epam.jwd.service;

import com.epam.jwd.domain.Triangle;

public interface Calculator {

    double geometricMean(double[] values);

    double geometricMeanFromLog(double[] logValues);

    double arithmeticMean(double[] values);

    double summation(double[] values);

    boolean isEvenNumber(double a);

    boolean isSumFirstTwoDigitEqualsSumLastTwoDigit(double a);

    boolean isXDigitNumber(double a, byte digitsInNumber);

    int sumOfDigits(int a);

    boolean triangleIsIsosceles(Triangle triangle);

    boolean sumOfAnyTwoDigitsEqualsThirdDigit(double a);

    boolean isOnePowerOfAnother(double n, double a);

}
