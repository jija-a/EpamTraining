package by.alex.task06.service;

import by.alex.task06.service.impl.CircleServiceImpl;
import by.alex.task06.service.impl.TriangleServiceImpl;
import by.alex.task06.service.impl.TriangleTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ServiceFactory {

    public static final ServiceFactory FACTORY = new ServiceFactory();

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ServiceFactory.class);

    private ServiceFactory() {
    }

    public CircleService getCircleService() {
        LOGGER.trace("Returning circle service instance");
        return CircleServiceImpl.SERVICE;
    }

    public TriangleService getTriangleService() {
        LOGGER.trace("Returning triangle service instance");
        return TriangleServiceImpl.SERVICE;
    }

    public TriangleTypeService getTriangleTypesService() {
        LOGGER.trace("Returning triangle types service instance");
        return TriangleTypeServiceImpl.SERVICE;
    }

}
