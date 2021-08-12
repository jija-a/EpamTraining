package by.alex.task03;

import by.alex.task03.context.Application;
import by.alex.task03.exception.InvalidStateException;
import by.alex.task03.service.ArrayService;
import by.alex.task03.service.impl.ArrayServiceImpl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /*try {
            Application.start();
        } catch (InvalidStateException e) {
            System.out.println("Invalid state of application, exiting...");
            System.exit(0);
        }*/

        ArrayServiceImpl arrayService = new ArrayServiceImpl();
        System.out.println(Arrays.toString(arrayService.generateRandomArray()));

    }

}
