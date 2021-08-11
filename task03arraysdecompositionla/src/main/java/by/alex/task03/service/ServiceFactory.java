package by.alex.task03.service;

import by.alex.task03.service.impl.ArrayServiceImpl;
import by.alex.task03.service.impl.MatrixServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final ArrayService arrayService = new ArrayServiceImpl();
    private final MatrixService matrixService = new MatrixServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ArrayService getArrayService() {
        return arrayService;
    }

    public MatrixService getMatrixService() {
        return matrixService;
    }

}
