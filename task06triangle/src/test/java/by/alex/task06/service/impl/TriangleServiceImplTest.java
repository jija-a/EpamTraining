package by.alex.task06.service.impl;

import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.TriangleService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class TriangleServiceImplTest {

    TriangleService service;

    @BeforeTest
    public void before() {
        service = TriangleServiceImpl.SERVICE;
    }

    @DataProvider
    public Object[][] createDataForAreaTest() {
        return new Object[][]{
                new Object[]{new Triangle(new ArrayList<>() {{
                    add(new CustomPoint(1, 1));
                    add(new CustomPoint(2, 2));
                    add(new CustomPoint(2, 5));
                }}, "triangle1"), 1.4999},
                new Object[]{new Triangle(new ArrayList<>() {{
                    add(new CustomPoint(2, 2));
                    add(new CustomPoint(8, 3));
                    add(new CustomPoint(4, 4));
                }}, "triangle2"), 5.0000},
                new Object[]{new Triangle(new ArrayList<>() {{
                    add(new CustomPoint(0, 0));
                    add(new CustomPoint(1, 1));
                    add(new CustomPoint(1, 2));
                }}, "triangle3"), 0.4999}
        };
    }

    @Test(dataProvider = "createDataForAreaTest")
    public void calcAreaTest(final Triangle triangle, double expected) {
        double actual = service.calcArea(triangle);
        double delta = 0.01;
        assertEquals(actual, expected, delta);
    }

    @DataProvider
    public Object[][] createDataForPerimeterTest() {
        return new Object[][]{
                new Object[]{new Triangle(new ArrayList<>() {{
                    add(new CustomPoint(1, 1));
                    add(new CustomPoint(2, 2));
                    add(new CustomPoint(2, 5));
                }}, "triangle1"), 8.5373},
                new Object[]{new Triangle(new ArrayList<>() {{
                    add(new CustomPoint(2, 2));
                    add(new CustomPoint(8, 3));
                    add(new CustomPoint(4, 4));
                }}, "triangle2"), 13.0342},
                new Object[]{new Triangle(new ArrayList<>() {{
                    add(new CustomPoint(0, 0));
                    add(new CustomPoint(1, 1));
                    add(new CustomPoint(1, 2));
                }}, "triangle3"), 4.6502}
        };
    }

    @Test(dataProvider = "createDataForPerimeterTest")
    public void calcPerimeterTest(Triangle triangle, double expected) {
        double actual = service.calcPerimeter(triangle);
        double delta = 0.01;
        assertEquals(actual, expected, delta);
    }

    @AfterTest
    public void after() {
        service = null;
    }
}