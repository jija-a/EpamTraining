package by.alex.task06.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class InputReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(InputReader.class);
    private static final String INPUT_CURSOR = "> ";
    private static final Scanner scanner = new Scanner(System.in);

    private InputReader() {
    }

    public static String readLine() {
        LOGGER.trace("Reading line input from console");
        ConsoleWriter.write(INPUT_CURSOR);
        return scanner.nextLine();
    }

    public static Long readLong() {
        LOGGER.trace("Reading long input from console");
        ConsoleWriter.write(INPUT_CURSOR);
        return scanner.nextLong();
    }

    public static Integer readInt() {
        LOGGER.trace("Reading int input from console");
        ConsoleWriter.write(INPUT_CURSOR);
        return scanner.nextInt();
    }

}
