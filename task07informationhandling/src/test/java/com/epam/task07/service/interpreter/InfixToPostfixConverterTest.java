package com.epam.task07.service.interpreter;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class InfixToPostfixConverterTest {

    @DataProvider(name = "data")
    private Object[][] getData() {
        return new Object[][]{
                {"30>>>3", "[30, 3, >>>]"},
                {"(8^5|1&2<<(2|5>>2&71))|1200", "[8, 5, ^, 1, 2, 2, 5, 2, >>, 71, &, |, <<, &, |, 1200, |]"},
                {"13<<2", "[13, 2, <<]"},
                {"~6&9|(3&4)", "[6, ~, 9, &, 3, 4, &, |]"},
                {"(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78", "[71, ~, 2, 3, &, 3, 2, 1, 2, >>, &, 2, |, 2, &, |, |, 10, 2, &, |, &, 78, |]"}};
    }

    @Test(dataProvider = "data")
    public void testInfixToPostfix(String expression, String expected) {
        List<String> actual = InfixToPostfixConverter.convert(expression);
        Assert.assertEquals(actual.toString(), expected);
    }

}