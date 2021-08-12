package by.alex.task03.context;

import by.alex.task03.context.impl.ApplicationContextImpl;
import by.alex.task03.domain.Array;
import by.alex.task03.domain.Matrix;

public interface ApplicationMenu {

    static void printAvailableOptions() {

            System.out.println("menu");
            int input = 2;
            handleUserInput(input);

    }

    static void handleUserInput(Object o) {
        System.out.println(ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Matrix.class));
        System.out.println(ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Array.class));
        System.out.println("handling input");
    }

}
