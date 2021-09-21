package by.alex.task06.service.observer;

import by.alex.task06.dao.repository.IdGenerator;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Figure;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.TriangleService;
import by.alex.task06.service.impl.TriangleServiceImpl;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FigureRegistrarTest {

    private Triangle triangle;
    private Characteristic characteristic;

    @BeforeTest
    public void before() {
        characteristic = new Characteristic();
        List<CustomPoint> points = new ArrayList<>() {{
            add(new CustomPoint(2, 2));
            add(new CustomPoint(8, 3));
            add(new CustomPoint(4, 4));
        }};
        triangle = new Triangle(points, "name1");
        triangle.setId(IdGenerator.generate());
        FigureRegistrar.REGISTRAR.putCharacteristic(triangle.getId(), characteristic);
    }

    @Test
    public void testContains() {
        FigureRegistrar.REGISTRAR.putCharacteristic(triangle.getId(), characteristic);
        boolean actual = FigureRegistrar.REGISTRAR.contains(triangle.getId());
        assertTrue(actual);
    }

    @Test
    public void testPutCharacteristic() {
        FigureRegistrar.REGISTRAR.putCharacteristic(triangle.getId(), characteristic);
        boolean actual = FigureRegistrar.REGISTRAR.contains(triangle.getId());
        assertTrue(actual);
    }

    @Test
    public void testGetCharacteristic() {
        Characteristic actual = FigureRegistrar.REGISTRAR.getCharacteristic(triangle.getId());
        assertEquals(actual, characteristic);
    }

    @Test
    public void testRemoveCharacteristic() {
        FigureRegistrar.REGISTRAR.removeCharacteristic(triangle.getId());
        boolean actual = FigureRegistrar.REGISTRAR.contains(triangle.getId());
        assertFalse(actual);
    }

    @AfterTest
    public void after() {
        characteristic = null;
        triangle = null;
    }
}
