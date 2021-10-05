package com.epam.task07.service.interpreter;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PolishCalculatorTest {

    @DataProvider(name = "correctData")
    private Object[][] provideCorrectData() {
        return new Object[][]{
                {new ArrayList<>() {{
                    add("30");
                    add("3");
                    add(">>>");
                }}, "3"},
                {new ArrayList<>() {{
                    add("13");
                    add("2");
                    add("<<");
                }}, "52"},
                {new ArrayList<>() {{
                    add("8");
                    add("5");
                    add("^");
                    add("1");
                    add("2");
                    add("2");
                    add("5");
                    add("2");
                    add(">>");
                    add("71");
                    add("&");
                    add("|");
                    add("<<");
                    add("&");
                    add("|");
                    add("1200");
                    add("|");
                }}, "1213"},
                {new ArrayList<>() {{
                    add("6");
                    add("~");
                    add("9");
                    add("&");
                    add("3");
                    add("4");
                    add("&");
                    add("|");
                }}, "9"},
                {new ArrayList<>() {{
                    add("71");
                    add("~");
                    add("2");
                    add("3");
                    add("&");
                    add("3");
                    add("2");
                    add("1");
                    add("2");
                    add(">>");
                    add("&");
                    add("2");
                    add("|");
                    add("2");
                    add("&");
                    add("|");
                    add("|");
                    add("10");
                    add("2");
                    add("&");
                    add("|");
                    add("&");
                    add("78");
                    add("|");
                }}, "78"}
        };
    }

    @Test(dataProvider = "correctData")
    public void testPolishCalculation(List<String> data, String expected) throws InterpreterException {
        String actual = PolishCalculator.calculate(data);
        Assert.assertEquals(actual, expected);
    }

}