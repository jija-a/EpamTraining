package com.epam.jwd.context.impl;

import com.epam.jwd.context.ApplicationMenu;
import com.epam.jwd.domain.Point;
import com.epam.jwd.service.impl.CalculatorImpl;
import com.epam.jwd.service.impl.PointServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DefaultMenu implements ApplicationMenu {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMenu.class);

    @Override
    public void printAvailableOptions() {
        byte input = -1;
        while (input != 6) {
            System.out.println("1. Find function c = a + 3" + "\n" +
                    "2. Math avg and Geo avg" + "\n" +
                    "3. Distance between two points" + "\n" +
                    "4. Power a^8 and a^10" + "\n" +
                    "5. True False menu" + "\n" +
                    "0. Exit " + "\n" +
                    "Enter option: ");
            try {
                LOGGER.info("Getting input from user");
                input = SCANNER.nextByte();
                handleUserInput(input);
            } catch (InputMismatchException ex) {
                LOGGER.info("Incorrect input from user: ", ex);
                System.out.println("Error: Incorrect input");
                SCANNER.nextLine();
            }
        }
    }

    @Override
    public void handleUserInput(byte input) {
        String result = "";
        LOGGER.info("Handling user input: ", input);
        switch (input) {
            case 1:
                result = this.handleCFunctionChoice();
                break;
            case 2:
                result = this.handleAvgChoice();
                break;
            case 3:
                result = this.handleDistanceChoice();
                break;
            case 4:
                result = this.handlePowChoice();
                break;
            case 5:
                TrueFalseMenu.TRUE_FALSE_MENU.printAvailableOptions();
                break;
            case 0:
                LOGGER.debug("Exiting application");
                System.out.println("Exit...");
                System.exit(-1);
                break;
            default:
                System.out.println("Unknown command, please, try again...");
                break;
        }
        System.out.println(result);
    }

    private String handleAvgChoice() {
        System.out.println("Enter a: ");
        double a = SCANNER.nextByte();
        System.out.println("Enter b: ");
        double b = SCANNER.nextByte();
        double[] values = new double[]{a, b};
        double mathAvg = CalculatorImpl.CALCULATOR.arithmeticMean(values);
        double geoAvg = CalculatorImpl.CALCULATOR.geometricMean(values);
        return "Math avg: " + mathAvg + "\nGeo avg: " + geoAvg;
    }

    private String handlePowChoice() {
        System.out.println("Enter 'a'");
        double a = SCANNER.nextDouble();
        double b = a * a;
        double c = b * b;
        double d = c * c;
        double e = d * b;
        return "a^8 = " + d + "\na^10 = " + e;
    }

    private String handleCFunctionChoice() {
        System.out.println("Enter 'a': ");
        double a = SCANNER.nextDouble();
        return a + 3 + "";
    }

    private String handleDistanceChoice() {
        System.out.println("Enter x1: ");
        double x1 = SCANNER.nextByte();
        System.out.println("Enter y1: ");
        double y1 = SCANNER.nextByte();
        System.out.println("Enter x2: ");
        double x2 = SCANNER.nextByte();
        System.out.println("Enter y2: ");
        double y2 = SCANNER.nextByte();
        Point firstPoint = new Point(x1, y1);
        Point secondPoint = new Point(x2, y2);
        double result = PointServiceImpl.POINT_SERVICE.findDistanceBetweenTwoPoints(firstPoint, secondPoint);
        return "Distance between two points is: " + result;
    }

}
