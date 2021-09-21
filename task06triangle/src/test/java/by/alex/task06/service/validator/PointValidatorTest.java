package by.alex.task06.service.validator;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PointValidatorTest {
    private PointValidator pointValidator;

    @BeforeTest
    public void before() {
        pointValidator = new PointValidator();
    }

    @DataProvider(name = "incorrectDataForREGEX")
    private Object[] createIncorrectDataForRegex() {
        return new Object[]{"1.0 2.0 3.0z",
                "1.0 2.0z",
                "1.0 2.0 3.0 1.2"
        };
    }

    @Test(dataProvider = "incorrectDataForREGEX")
    public void testLineIsNotValid(String value) {
        boolean actual = pointValidator.isFileLineMatchesRegex(value);
        Assert.assertFalse(actual);
    }

    @DataProvider(name = "correctDataForREGEX")
    private Object[] createCorrectDataForRegex() {
        return new Object[]{"1.0 2.0",
                "1.0 1.0",
                "2.0 10000.0"
        };
    }

    @Test(dataProvider = "correctDataForREGEX")
    public void testLineIsValid(String value) {
        boolean actual = pointValidator.isFileLineMatchesRegex(value);
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "correctDataForExist")
    private Object[] createCorrectDataForExist() {
        return new Object[]{1, 2, 1000};
    }

    @AfterTest
    public void after() {
        pointValidator = null;
    }
}