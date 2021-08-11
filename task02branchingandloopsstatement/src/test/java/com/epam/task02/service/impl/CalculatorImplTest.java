package com.epam.task02.service.impl;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorImplTest {

    @DataProvider(name = "dataForMaxFunction")
    public Object[] createDataForMaxFunction() {
        return
                new Object[]{
                        new int[]{19, -1},
                        new int[]{-1, -5},
                        new int[]{0, -1},
                        new int[]{0, -10000000},
                };
    }

    @DataProvider(name = "dataForMinFunction")
    public Object[] createIncorrectDataForEvenNumber() {
        return
                new Object[]{
                        new int[]{19, -1},
                        new int[]{-1, -5},
                        new int[]{0, -1},
                        new int[]{0, -10000000},
                };
    }

    @Test(dataProvider = "dataForMaxFunction")
    public void testMaxFunction(int max, int min) {
        assertEquals(max, CalculatorImpl.CALCULATOR.findMax(max, min));
    }

    @Test(dataProvider = "dataForMinFunction")
    public void testMinFunction(int max, int min) {
        assertEquals(min, CalculatorImpl.CALCULATOR.findMin(max, min));
    }

}