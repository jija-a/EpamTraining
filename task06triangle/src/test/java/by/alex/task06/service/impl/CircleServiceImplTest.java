package by.alex.task06.service.impl;

import by.alex.task06.domain.Circle;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.service.CircleService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CircleServiceImplTest {

    private CircleService service;

    @BeforeTest
    public void before() {
        service = CircleServiceImpl.SERVICE;
    }

    @DataProvider
    public Object[][] createDataForAreaTest() {
        return new Object[][]{
                new Object[]{new Circle(new CustomPoint(1, 1), 2, "name1"), 12.5663},
                new Object[]{new Circle(new CustomPoint(1, 1), 5, "name1"), 78.5398},
                new Object[]{new Circle(new CustomPoint(2, 2), 10, "name1"), 314.1592}
        };
    }

    @Test(dataProvider = "createDataForAreaTest")
    public void calcAreaTest(final Circle circle, double expected) {
        double actual = service.calcArea(circle);
        double delta = 0.01;
        assertEquals(actual, expected, delta);
    }

    @DataProvider
    public Object[][] createDataForPerimeterTest() {
        return new Object[][]{
                new Object[]{new Circle(new CustomPoint(1, 1), 2, "name1"), 12.5663},
                new Object[]{new Circle(new CustomPoint(1, 1), 5, "name1"), 31.4159},
                new Object[]{new Circle(new CustomPoint(2, 2), 10, "name1"), 62.8318}
        };
    }

    @Test(dataProvider = "createDataForPerimeterTest")
    public void calcPerimeterTest(final Circle circle, double expected) {
        double actual = service.calcPerimeter(circle);
        double delta = 0.01;
        assertEquals(actual, expected, delta);
    }

    @AfterTest
    public void after() {
        service = null;
    }
}