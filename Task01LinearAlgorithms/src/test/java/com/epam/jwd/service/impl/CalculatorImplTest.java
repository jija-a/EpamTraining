package com.epam.jwd.service.impl;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorImplTest {

    @DataProvider(name = "correctDataForEvenNumber")
    public Object[] createCorrectDataForEvenNumber() {
        return
                new Object[]{20, 0, -12};
    }


    @DataProvider(name = "incorrectDataForEvenNumber")
    public Object[] createIncorrectDataForEvenNumber() {
        return
                new Object[]{19, -1};
    }

    @DataProvider(name = "correctDataForDigits")
    public Object[] createCorrectDataForDigits() {
        return
                new Object[]{new int[]{1, 1},
                        new int[]{-1, 1},
                        new int[]{123, 3},
                };
    }

    @DataProvider(name = "incorrectDataForDigits")
    public Object[] createIncorrectDataForDigits() {
        return
                new Object[]{new int[]{1, 0},
                        new int[]{-1, 2},
                        new int[]{0, 2},
                };
    }

    @Test(dataProvider = "correctDataForEvenNumber")
    public void testEvenNumber(int a) {
        assertTrue(CalculatorImpl.CALCULATOR.isEvenNumber(a));
    }


    @Test(dataProvider = "incorrectDataForEvenNumber")
    public void testNotEvenNumber(int a) {
        assertFalse(CalculatorImpl.CALCULATOR.isEvenNumber(a));
    }

    @Test(dataProvider = "incorrectDataForDigits")
    public void testIncorrectDigitsInNumber(int[] values) {
        assertFalse(CalculatorImpl.CALCULATOR.isXDigitNumber(values[0], values[1]));
    }

    @Test(dataProvider = "correctDataForDigits")
    public void testCorrectDigitsInNumber(int[] values) {
        assertTrue(CalculatorImpl.CALCULATOR.isXDigitNumber(values[0], values[1]));
    }

}