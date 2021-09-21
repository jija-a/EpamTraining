package by.alex.task06.service.validator;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CircleValidatorTest {
    private CircleValidator circleValidator;

    @BeforeTest
    public void before() {
        circleValidator = new CircleValidator();
    }

    @DataProvider(name = "incorrectDataForREGEX")
    private Object[] createIncorrectDataForRegex() {
        return new Object[]{"1.0 2.0 3.0z",
                "1.0 2.0",
                "1.0 2.0 3.0 1.2 circle1"
        };
    }

    @Test(dataProvider = "incorrectDataForREGEX")
    public void testLineIsNotValid(String value) {
        boolean actual = circleValidator.isFileLineMatchesRegex(value);
        Assert.assertFalse(actual);
    }

    @DataProvider(name = "correctDataForREGEX")
    private Object[] createCorrectDataForRegex() {
        return new Object[]{"1.0 2.0 3.0 circle1",
                "-1.0 -2.0 2.0 circle2",
                "-50.0 100.30 1500.0 circle3"
        };
    }

    @Test(dataProvider = "correctDataForREGEX")
    public void testLineIsValid(String value) {
        boolean actual = circleValidator.isFileLineMatchesRegex(value);
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "correctDataForExist")
    private Object[] createCorrectDataForExist() {
        return new Object[]{1, 2, 1000};
    }

    @Test(dataProvider = "correctDataForExist")
    public void testRadiusIsValid(double value) {
        boolean actual = circleValidator.isCircleExists(value);
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "incorrectDataForExist")
    private Object[] createIncorrectDataForExist() {
        return new Object[]{-1, 0, -100};
    }

    @Test(dataProvider = "incorrectDataForExist")
    public void testRadiusIsNotValid(double value) {
        boolean actual = circleValidator.isCircleExists(value);
        Assert.assertFalse(actual);
    }

    @AfterTest
    public void after() {
        circleValidator = null;
    }
}