package com.epam.task01.context.impl;

import com.epam.task01.context.ApplicationMenu;
import com.epam.task01.domain.Point;
import com.epam.task01.service.impl.CalculatorImpl;
import com.epam.task01.service.impl.PointServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationMainMenu implements ApplicationMenu {

    public static final ApplicationMenu DEFAULT_MENU = new ApplicationMainMenu();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMainMenu.class);

    @Override
    public void printAvailableOptions() {
        byte input = -1;
        while (input != 0) {
            System.out.println("1. Find function c = a + 3" + "\n"
                    + "2. Math avg and Geo avg" + "\n"
                    + "3. Distance between two points" + "\n"
                    + "4. Power a^8 and a^10" + "\n"
                    + "5. True False menu" + "\n"
                    + "0. Exit " + "\n"
                    + "Enter option: ");
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
        double a;
        double b;
        double[] values;
        double mathAvg;
        double geoAvg;
        double x1;
        double y1;
        double x2;
        double y2;
        double distance;
        double eightPow;
        double tenPow;

        String result = "";
        LOGGER.info("Handling user input: ");
        switch (input) {
            case 1:
                LOGGER.trace("User choose Case 1");
                System.out.println("Enter 'a': ");
                a = SCANNER.nextDouble();

                result = String.valueOf(CalculatorImpl.CALCULATOR.calculateCFunction(a));
                break;
            case 2:
                LOGGER.trace("User choose Case 2");
                System.out.println("Enter a: ");
                a = SCANNER.nextByte();
                System.out.println("Enter b: ");
                b = SCANNER.nextByte();

                values = new double[]{a, b};
                mathAvg = CalculatorImpl.CALCULATOR.arithmeticMean(values);
                geoAvg = CalculatorImpl.CALCULATOR.geometricMean(values);

                result = "Math avg: " + mathAvg + "\nGeo avg: " + geoAvg;
                break;
            case 3:
                LOGGER.trace("User choose Case 3");
                System.out.println("Enter x1: ");
                x1 = SCANNER.nextByte();
                System.out.println("Enter y1: ");
                y1 = SCANNER.nextByte();
                System.out.println("Enter x2: ");
                x2 = SCANNER.nextByte();
                System.out.println("Enter y2: ");
                y2 = SCANNER.nextByte();

                Point firstPoint = new Point(x1, y1);
                Point secondPoint = new Point(x2, y2);
                distance = PointServiceImpl.POINT_SERVICE.findDistanceBetweenTwoPoints(firstPoint, secondPoint);

                result = "Distance between two points is: " + distance;
                break;
            case 4:
                LOGGER.trace("User choose Case 4");
                System.out.println("Enter 'a'");
                a = SCANNER.nextDouble();

                eightPow = CalculatorImpl.CALCULATOR.numberInEightPowOnlyByMultiplying(a);
                tenPow = CalculatorImpl.CALCULATOR.numberInTenPowOnlyByMultiplying(a);

                result = "a^8 = " + eightPow + "\na^10 = " + tenPow;
                break;
            case 5:
                LOGGER.trace("User choose Case 5");
                ApplicationTrueFalseMenu.TRUE_FALSE_MENU.printAvailableOptions();
                break;
            case 0:
                LOGGER.info("Exit application");
                System.out.println("Exit...");
                System.exit(-1);
                break;
            default:
                System.out.println("Unknown command, please, try again...");
                break;
        }
        System.out.println(result);
    }

}
