package by.alex.task06.service.observer.impl;

import by.alex.task06.dao.repository.IdGenerator;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.observer.Characteristic;
import by.alex.task06.service.observer.FigureEvent;
import by.alex.task06.service.observer.FigureRegistrar;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleAreaObserverTest {
    private Triangle triangle;
    private Characteristic characteristic;

    @BeforeTest
    public void before() {
        List<CustomPoint> points = new ArrayList<>() {{
            add(new CustomPoint(2, 2));
            add(new CustomPoint(8, 3));
            add(new CustomPoint(4, 4));
        }};
        triangle = new Triangle(points, "name1");
        triangle.setId(IdGenerator.generate());
        characteristic = new Characteristic();
        characteristic.setArea(5.0000);
        FigureRegistrar.REGISTRAR.putCharacteristic(triangle.getId(), characteristic);
    }

    @Test
    public void testUpdate() {
        List<CustomPoint> points = new ArrayList<>() {{
            add(new CustomPoint(1, 1));
            add(new CustomPoint(2, 2));
            add(new CustomPoint(2, 5));
        }};
        triangle.setPoints(points);
        FigureEvent event = new FigureEvent(triangle);
        new TriangleAreaObserver().update(event);
        double actual = FigureRegistrar.REGISTRAR.getCharacteristic(triangle.getId()).getArea();
        double expected = 1.4999;
        double delta = 0.0001;
        Assert.assertEquals(actual, expected, delta);
    }

    @AfterTest
    public void after() {
        FigureRegistrar.REGISTRAR.removeCharacteristic(triangle.getId());
        triangle = null;
        characteristic = null;
    }
}
