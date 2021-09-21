package by.alex.task06.service.creator;

import by.alex.task06.domain.Circle;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Figure;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CircleCreatorTest {

    CircleCreator creator;

    @BeforeTest
    public void before() {
        creator = CircleCreator.CREATOR;
    }

    @Test
    public void testCreate() {
        Figure actual = creator.create(new CustomPoint(1, 1), 1, "name1");
        Figure expected = new Circle(new CustomPoint(1, 1), 1, "name1");
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = WrongArgumentsException.class)
    public void testCreateException() {
        creator.create(new CustomPoint(1, 1), -1, "name1");
    }

    @AfterTest
    public void after() {
        creator = null;
    }

}