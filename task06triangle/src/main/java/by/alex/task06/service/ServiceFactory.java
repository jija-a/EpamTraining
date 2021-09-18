package by.alex.task06.service;

import by.alex.task06.service.impl.CircleServiceImpl;
import by.alex.task06.service.impl.TriangleServiceImpl;
import by.alex.task06.service.impl.TriangleTypeServiceImpl;

public class ServiceFactory {

    public static final ServiceFactory FACTORY = new ServiceFactory();

    private ServiceFactory(){
    }

    public CircleService getCircleService(){
        return CircleServiceImpl.SERVICE;
    }

    public TriangleService getTriangleService(){
        return TriangleServiceImpl.SERVICE;
    }

    public TriangleTypeService getTriangleTypesService(){
        return TriangleTypeServiceImpl.SERVICE;
    }

}
