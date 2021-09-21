package by.alex.task06.service.impl;

import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.TriangleTypeService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TriangleTypeServiceImplTest {

    private TriangleTypeService typeService;

    @BeforeTest
    public void before() {
        typeService = TriangleTypeServiceImpl.SERVICE;
    }

    @DataProvider
    public Object[][] createDataForTypeTest() {
        return new Object[][]{
                new Object[]{new Triangle(new ArrayList<>() {{
                    add(new CustomPoint(1, 1));
                    add(new CustomPoint(2, 2));
                    add(new CustomPoint(2, 5));
                }}, "triangle1"), new ArrayList<>() {{
                    add(Triangle.TriangleType.OBTUSE);
                }}},
                new Object[]{new Triangle(new ArrayList<>() {{
                    add(new CustomPoint(0, 0));
                    add(new CustomPoint(2, 0));
                    add(new CustomPoint(0, 2));
                }}, "triangle2"), new ArrayList<>() {{
                    add(Triangle.TriangleType.OBTUSE);
                    add(Triangle.TriangleType.ISOSCELES);
                }}},
                new Object[]{new Triangle(new ArrayList<>() {{
                    add(new CustomPoint(0, 0));
                    add(new CustomPoint(1, 1));
                    add(new CustomPoint(1, 2));
                }}, "triangle3"), new ArrayList<>() {{
                    add(Triangle.TriangleType.OBTUSE);
                }}}
        };
    }

    @Test(dataProvider = "createDataForTypeTest")
    public void testTypeDefine(Triangle triangle,
                               List<Triangle.TriangleType> expected) {

        List<Triangle.TriangleType> actual = typeService.defineType(triangle);
        assertEquals(actual, expected);
    }

    @AfterTest
    public void after() {
        typeService = null;
    }

}