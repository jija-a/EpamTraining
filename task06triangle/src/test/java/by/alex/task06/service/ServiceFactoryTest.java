package by.alex.task06.service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ServiceFactoryTest {

    @Test
    public void testGetCircleService() {
        boolean actual = ServiceFactory.FACTORY.getCircleService() != null;
        Assert.assertTrue(actual);
    }

    @Test
    public void testGetTriangleService() {
        boolean actual = ServiceFactory.FACTORY.getTriangleService() != null;
        Assert.assertTrue(actual);
    }

    @Test
    public void testGetTriangleTypesService() {
        boolean actual = ServiceFactory.FACTORY.getTriangleTypesService() != null;
        Assert.assertTrue(actual);
    }
}
