package by.alex.task06.service.validator;

import by.alex.task06.domain.CustomPoint;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleValidatorTest {
    private TriangleValidator triangleValidator;

    @BeforeTest
    public void before() {
        triangleValidator = new TriangleValidator();
    }

    @DataProvider(name = "incorrectDataForREGEX")
    private Object[] createIncorrectDataForRegex() {
        return new Object[]{"1z.0 1.0 2.0 2.2 2.0 1.0 triangle2",
                "1.0 2.0 3.0 4.0 5.0 triangle5",
                "5.0 3.0 9.0 3.0 7.0 8.0 1.0 triangle6"
        };
    }

    @Test(dataProvider = "incorrectDataForREGEX")
    public void testLineIsNotValid(String value) {
        boolean actual = triangleValidator.isFileLineMatchesRegex(value);
        Assert.assertFalse(actual);
    }

    @DataProvider(name = "correctDataForREGEX")
    private Object[] createCorrectDataForRegex() {
        return new Object[]{"1.0 1.0 2.0 2.0 2.0 1.0 triangle1",
                "3.0 1.0 3.0 4.0 8.0 1.0 triangle3",
                "5.0 3.0 9.0 3.0 7.0 8.0 triangle6"
        };
    }

    @Test(dataProvider = "correctDataForREGEX")
    public void testLineIsValid(String value) {
        boolean actual = triangleValidator.isFileLineMatchesRegex(value);
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "correctDataForExist")
    private Object[] createCorrectDataForExist() {
        return new Object[]{
                new ArrayList<CustomPoint>() {{
                    add(new CustomPoint(1, 1));
                    add(new CustomPoint(2, 2));
                    add(new CustomPoint(2, 1));
                }},
                new ArrayList<CustomPoint>() {{
                    add(new CustomPoint(3, 1));
                    add(new CustomPoint(3, 4));
                    add(new CustomPoint(8, 1));
                }},
                new ArrayList<CustomPoint>() {{
                    add(new CustomPoint(5, 3));
                    add(new CustomPoint(9, 3));
                    add(new CustomPoint(7, 8));
                }},
        };
    }

    @Test(dataProvider = "correctDataForExist")
    public void testTriangleIsValid(List<CustomPoint> value) {
        boolean actual = triangleValidator.isTriangleExists(value);
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "incorrectDataForExist")
    private Object[] createIncorrectDataForExist() {
        return new Object[]{
                new ArrayList<CustomPoint>() {{
                    add(new CustomPoint(1, 1));
                    add(new CustomPoint(1, 1));
                    add(new CustomPoint(2, 1));
                }},
                new ArrayList<CustomPoint>() {{
                    add(new CustomPoint(3, 1));
                    add(new CustomPoint(3, 4));
                    add(new CustomPoint(3, 4));
                }},
                new ArrayList<CustomPoint>() {{
                    add(new CustomPoint(1, 0));
                    add(new CustomPoint(2, 0));
                    add(new CustomPoint(3, 0));
                }},
        };
    }

    @Test(dataProvider = "incorrectDataForExist")
    public void testTriangleIsNotValid(List<CustomPoint> value) {
        boolean actual = triangleValidator.isTriangleExists(value);
        Assert.assertFalse(actual);
    }

    @AfterTest
    public void after() {
        triangleValidator = null;
    }
}
