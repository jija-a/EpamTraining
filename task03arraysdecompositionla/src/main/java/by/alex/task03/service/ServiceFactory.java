package by.alex.task03.service;

import by.alex.task03.service.impl.CustomArrayServiceImpl;
import by.alex.task03.service.impl.MatrixServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final CustomArrayService customArrayService = new CustomArrayServiceImpl();
    private final MatrixService matrixService = new MatrixServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public CustomArrayService getArrayService() {
        return customArrayService;
    }

    public MatrixService getMatrixService() {
        return matrixService;
    }

}
