package com.epam.jwd.service.impl;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorImplTest {

    @Test
    public void testIsEvenNumber() {
        double a1 = 20;
        double a2 = 19;
        double a3 = -1;
        double a4 = 0;
        double a5 = -12;
        assertTrue(CalculatorImpl.CALCULATOR.isEvenNumber(a1));
        assertFalse(CalculatorImpl.CALCULATOR.isEvenNumber(a2));
        assertFalse(CalculatorImpl.CALCULATOR.isEvenNumber(a3));
        assertTrue(CalculatorImpl.CALCULATOR.isEvenNumber(a4));
        assertTrue(CalculatorImpl.CALCULATOR.isEvenNumber(a5));
    }

    @Test
    public void testIsXDigitNumber() {
        byte digitsInNumber1 = 0;
        byte digitsInNumber2 = 2;
        byte digitsInNumber3 = -1;
        double a1 = 0;
        double a2 = 12;
        double a3 = 123;
        assertFalse(CalculatorImpl.CALCULATOR.isXDigitNumber(a1, digitsInNumber1));
        assertFalse(CalculatorImpl.CALCULATOR.isXDigitNumber(a1, digitsInNumber2));
        assertFalse(CalculatorImpl.CALCULATOR.isXDigitNumber(a1, digitsInNumber3));
        assertFalse(CalculatorImpl.CALCULATOR.isXDigitNumber(a2, digitsInNumber1));
        assertTrue(CalculatorImpl.CALCULATOR.isXDigitNumber(a2, digitsInNumber2));
        assertFalse(CalculatorImpl.CALCULATOR.isXDigitNumber(a2, digitsInNumber3));
        assertFalse(CalculatorImpl.CALCULATOR.isXDigitNumber(a3, digitsInNumber1));
        assertFalse(CalculatorImpl.CALCULATOR.isXDigitNumber(a3, digitsInNumber2));
        assertFalse(CalculatorImpl.CALCULATOR.isXDigitNumber(a3, digitsInNumber3));
    }

}