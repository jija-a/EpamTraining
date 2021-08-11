package com.epam.task02.context.util;

import com.epam.task02.context.impl.ApplicationContextImpl;
import com.epam.task02.util.MessageConstant;
import com.epam.task02.util.MessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(InputReader.class);
    private static final String[] LETTERS = new String[]{"a", "b", "c", "d", "e", "f", "g"};
    private static final String INPUT_CURSOR = "> ";
    private static final Scanner scanner = new Scanner(System.in);

    private InputReader() {
    }

    public static String readLine() {
        LOGGER.trace("reading line");
        System.out.print(INPUT_CURSOR);
        return scanner.nextLine();
    }

    public static Double readDouble() {
        LOGGER.trace("reading double");
        System.out.print(INPUT_CURSOR);
        return scanner.nextDouble();
    }

    public static Integer readInteger() {
        LOGGER.trace("reading integer");
        System.out.print(INPUT_CURSOR);
        return scanner.nextInt();
    }

    public static List<Double> readInput(InputType inputType, int numbersQty) {
        LOGGER.trace("reading input");

        if (inputType.equals(InputType.FILE)) {
            LOGGER.trace("from file");
            return ApplicationContextImpl.APPLICATION_CONTEXT.retrieveNumbers();
        }

        LOGGER.trace("from console");
        List<Double> values = new ArrayList<>();

        for (int i = 0; i < numbersQty; i++) {
            System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.MAIN_PLEASE_INPUT) + " " + LETTERS[i]);
            values.add(InputReader.readDouble());
        }

        return values;
    }

}
