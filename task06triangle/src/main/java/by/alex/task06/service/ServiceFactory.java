package by.alex.task06.service;

import by.alex.task06.service.impl.CircleServiceImpl;
import by.alex.task06.service.impl.TriangleServiceImpl;
import by.alex.task06.service.impl.TriangleTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ServiceFactory {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ServiceFactory.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final ServiceFactory FACTORY = new ServiceFactory();

    /**
     * Private class constructor.
     */
    private ServiceFactory() {
    }

    /**
     * Method to return {@link CircleService} instance.
     *
     * @return {@link CircleService}
     */
    public CircleService getCircleService() {
        LOGGER.trace("Returning circle service instance");
        return CircleServiceImpl.SERVICE;
    }

    /**
     * Method to return {@link TriangleService} instance.
     *
     * @return {@link TriangleService}
     */
    public TriangleService getTriangleService() {
        LOGGER.trace("Returning triangle service instance");
        return TriangleServiceImpl.SERVICE;
    }

    /**
     * Method to return {@link TriangleTypeService} instance.
     *
     * @return {@link TriangleTypeService}
     */
    public TriangleTypeService getTriangleTypesService() {
        LOGGER.trace("Returning triangle types service instance");
        return TriangleTypeServiceImpl.SERVICE;
    }
}
