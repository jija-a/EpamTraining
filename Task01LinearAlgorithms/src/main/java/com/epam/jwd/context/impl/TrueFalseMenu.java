package com.epam.jwd.context.impl;

import com.epam.jwd.context.ApplicationMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TrueFalseMenu implements ApplicationMenu {

    protected static final TrueFalseMenu TRUE_FALSE_MENU = new TrueFalseMenu();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = LoggerFactory.getLogger(TrueFalseMenu.class);

    @Override
    public void printAvailableOptions() {
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
        LOGGER.info("Handling user input");
        boolean result = false;
        switch (input) {
            case 1:
                result = this.handleFirstTask();
                break;
            case 2:
                result = this.handleSecondTask();
                break;
            case 3:
                result = this.handleThirdTask();
                break;
            case 4:
                result = this.handleFourthTask();
                break;
            case 5:
                result = this.handleFifthTask();
                break;
            case 6:
                result = this.handleSixTask();
                break;
            case 7:
                result = this.handleSevenTask();
                break;
            case 8:
                result = this.handleEightTask();
                break;
            case 9:
                result = this.handleNineTask();
                break;
            case 0:
                break;
            default:
                System.out.println("Unknown command, please, try again...");
                break;
        }
        System.out.println(result);
    }

    private boolean handleFirstTask() {
        System.out.print("Input 'a': ");
        double a = SCANNER.nextDouble();

        return a > 9 && a < 100 && a % 2 == 0;
    }

    private boolean handleSecondTask() {
        System.out.print("Input 'a': ");
        double a = SCANNER.nextDouble();

        return (a % 2 == 0) &&
                (Math.round(a / 1000) + Math.round((a / 100) % 10) == Math.round((a % 100) / 10) + Math.round(a % 10));
    }

    private boolean handleThirdTask() {
        boolean result = false;
        System.out.print("Input 'a': ");
        double a = SCANNER.nextDouble();

        while (a > 99 && a < 1000) {
            result = (Math.round(a / 100) + (a / 10 % 10) + (a % 10)) % 2 == 0;
        }
        return result;
    }

    private boolean handleFourthTask() {
        System.out.print("Input 'x': ");
        double x = SCANNER.nextDouble();
        System.out.print("Input 'y': ");
        double y = SCANNER.nextDouble();
        System.out.print("Input 'm': ");
        double m = SCANNER.nextDouble();
        System.out.print("Input 'n': ");
        double n = SCANNER.nextDouble();

        return x >= m && x <= n;
    }

    private boolean handleFifthTask() {
        System.out.print("Input 'a': ");
        double a = SCANNER.nextDouble();

        double sum = 0;
        double newA = a;
        int count = 0;
        while (count < 3) {
            sum = sum + (newA % 10);
            newA = newA / 10;
            count++;
        }

        return a * a == Math.pow(sum, 3);
    }

    private boolean handleSixTask() {
        System.out.print("Input 'a': ");
        double a = SCANNER.nextDouble();
        System.out.print("Input 'b': ");
        double b = SCANNER.nextDouble();
        System.out.print("Input 'c': ");
        double c = SCANNER.nextDouble();

        return (a == b && a != c) || (a == c && a != b) || (b == c && b != a);
    }

    private boolean handleSevenTask() {
        System.out.print("Input 'a': ");
        double a = SCANNER.nextDouble();

        double newA = a;
        double firstDigit = newA % 10;
        newA = newA / 10;
        double secondDigit = newA % 10;
        newA = newA / 10;
        double thirdDigit = newA % 10;

        return firstDigit + secondDigit == thirdDigit
                || firstDigit + thirdDigit == secondDigit
                || thirdDigit + secondDigit == firstDigit;
    }

    private boolean handleEightTask() {
        System.out.print("Input 'n': ");
        double n = SCANNER.nextDouble();
        System.out.print("Input 'a': ");
        double a = SCANNER.nextDouble();

        return (n == 1) || (n == a) || (n == a * a) || (n == Math.pow(a, 3)) || (n == Math.pow(a, 4));
    }

    private boolean handleNineTask() {
        System.out.print("Input 'a': ");
        double a = SCANNER.nextDouble();
        System.out.print("Input 'b': ");
        double b = SCANNER.nextDouble();
        System.out.print("Input 'c': ");
        double c = SCANNER.nextDouble();
        System.out.print("Input 'x': ");
        double x = SCANNER.nextDouble();
        System.out.print("Input 'y': ");
        double y = SCANNER.nextDouble();

        return y == a * x * x + b * x + c;
    }

}
