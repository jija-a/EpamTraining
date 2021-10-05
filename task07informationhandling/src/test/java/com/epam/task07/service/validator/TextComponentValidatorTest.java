package com.epam.task07.service.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TextComponentValidatorTest {

    @DataProvider(name = "mathExpressions")
    private Object[] mathExpressionData() {
        return new Object[]{
                "(8^5|1&2<<(2|5>>2&71))|1200",
                "13<<2",
                "30>>>2",
                "12~21+23|2",
                "10|10&20"
        };
    }

    @Test(dataProvider = "mathExpressions")
    public void dataIsMathExpression(String expression) {
        boolean actual = TextComponentValidator.VALIDATOR.isExpression(expression);
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "notMathExpressions")
    private Object[] notMathExpressionData() {
        return new Object[]{
                "regular&not|regular",
                "always|(5)",
                "(five)",
                "15",
                "not"
        };
    }

    @Test(dataProvider = "notMathExpressions")
    public void dataIsNotMathExpression(String expression) {
        boolean actual = TextComponentValidator.VALIDATOR.isExpression(expression);
        Assert.assertFalse(actual);
    }

}