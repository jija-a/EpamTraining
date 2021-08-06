package com.epam.jwd.context.impl;

import com.epam.jwd.context.ApplicationMenu;
import com.epam.jwd.domain.Point;
import com.epam.jwd.domain.Triangle;
import com.epam.jwd.service.Calculator;
import com.epam.jwd.service.impl.CalculatorImpl;
import com.epam.jwd.service.impl.PointServiceImpl;
import com.epam.jwd.service.impl.TriangleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TrueFalseMenu implements ApplicationMenu {

    protected static final TrueFalseMenu TRUE_FALSE_MENU = new TrueFalseMenu();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = LoggerFactory.getLogger(TrueFalseMenu.class);
    private Calculator calculator = CalculatorImpl.CALCULATOR;

    @Override
    public void printAvailableOptions() {
        LOGGER.info("Showing true false menu");
        byte input = -1;
        while (input != 0) {
            System.out.println("1. The integer N is an even two-digit number.\n" +
                    "2. The sum of the first two digits of a given four-digit number is equal to the sum of the last two digits.\n" +
                    "3. The sum of the digits of a given three-digit number N is an even number.\n" +
                    "4. A point with coordinates (x, y) belongs to the part of the plane lying between the straight lines x = t, x = n (t <n).\n" +
                    "5. The square of a given three-digit number is equal to the cube of the sum of the digits of that number.\n" +
                    "6. A triangle with sides a, b, c is isosceles.\n" +
                    "7. The sum of any two digits of a given three-digit natural number N is equal to the third digit.\n" +
                    "8. The specified number N is a power of a (the exponent can range from 0 to 4).\n" +
                    "9. The graph of the function y = ax2 + bx + c passes through a given point with coordinates (m, n).\n" +
                    "0. Back to main menu");
            try {
                LOGGER.info("Getting user input");
                input = SCANNER.nextByte();
                handleUserInput(input);
            } catch (InputMismatchException ex) {
                LOGGER.info("Incorrect user input: ", ex);
                System.out.println("Error: Incorrect input");
                SCANNER.nextLine();
            }
        }
    }

    @Override
    public void handleUserInput(byte input) {
        int sum;
        double a;
        double b;
        double c;
        double x;
        double y;
        double m;
        double n;
        int digitsInNumber;
        LOGGER.info("Handling user input");
        boolean result = false;
        switch (input) {
            case 1:
                LOGGER.trace("User choose Case 1");
                digitsInNumber = 2;
                System.out.print("Input 'a': ");
                a = SCANNER.nextDouble();

                result = calculator.isEvenNumber(a) && calculator.isXDigitNumber(a, digitsInNumber);
                break;
            case 2:
                LOGGER.trace("User choose Case 2");
                digitsInNumber = 4;
                System.out.print("Input 'a': ");
                a = SCANNER.nextDouble();

                result = calculator.isXDigitNumber(a, digitsInNumber) && calculator.isSumFirstTwoDigitEqualsSumLastTwoDigit(a);
                break;
            case 3:
                LOGGER.trace("User choose Case 3");
                digitsInNumber = 3;
                System.out.print("Input 'a': ");
                a = SCANNER.nextDouble();

                sum = calculator.sumOfDigits((int) a);
                result = calculator.isXDigitNumber(a, digitsInNumber) && calculator.isEvenNumber(sum);
                break;
            case 4:
                LOGGER.trace("User choose Case 4");
                System.out.print("Input 'x': ");
                x = SCANNER.nextDouble();
                System.out.print("Input 'y': ");
                y = SCANNER.nextDouble();
                Point point = new Point(x, y);
                System.out.print("Input 'm': ");
                m = SCANNER.nextDouble();
                System.out.print("Input 'n': ");
                n = SCANNER.nextDouble();

                result = PointServiceImpl.POINT_SERVICE.isPointBelongsToLine(point, m, n);
                break;
            case 5:
                LOGGER.trace("User choose Case 5");
                System.out.print("Input 'a': ");
                a = SCANNER.nextDouble();

                sum = calculator.sumOfDigits((int) a);

                result = a * a == Math.pow(sum, 3);
                break;
            case 6:
                LOGGER.trace("User choose Case 6");
                System.out.print("Input 'a': ");
                a = SCANNER.nextDouble();
                System.out.print("Input 'b': ");
                b = SCANNER.nextDouble();
                System.out.print("Input 'c': ");
                c = SCANNER.nextDouble();

                result = TriangleServiceImpl.TRIANGLE_SERVICE.triangleIsIsosceles(new Triangle(a, b, c));
                break;
            case 7:
                LOGGER.trace("User choose Case 7");
                digitsInNumber = 3;
                System.out.print("Input 'a': ");
                a = SCANNER.nextDouble();

                result = calculator.isXDigitNumber(a, digitsInNumber) && calculator.sumOfAnyTwoDigitsEqualsThirdDigit(a);
                break;
            case 8:
                LOGGER.trace("User choose Case 8");

                System.out.print("Input 'n': ");
                n = SCANNER.nextDouble();
                System.out.print("Input 'a': ");
                a = SCANNER.nextDouble();

                result = calculator.isOnePowerOfAnother(n, a);
                break;
            case 9:
                LOGGER.trace("User choose Case 9");
                System.out.print("Input 'a': ");
                a = SCANNER.nextDouble();
                System.out.print("Input 'b': ");
                b = SCANNER.nextDouble();
                System.out.print("Input 'c': ");
                c = SCANNER.nextDouble();
                System.out.print("Input 'x': ");
                x = SCANNER.nextDouble();
                System.out.print("Input 'y': ");
                y = SCANNER.nextDouble();

                result = y == a * x * x + b * x + c;
                break;
            case 0:
                LOGGER.trace("User choose Case 0");
                LOGGER.trace("Go back to Main menu");
                break;
            default:
                System.out.println("Unknown command, please, try again...");
                break;
        }
        System.out.println(result);
    }

}
