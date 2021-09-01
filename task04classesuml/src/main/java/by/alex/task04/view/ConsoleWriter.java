package by.alex.task04.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleWriter.class);

    private ConsoleWriter() {
    }

    public static void writeln(String msg) {
        LOGGER.trace("Writing message to console");
        System.out.println(msg);
    }

    public static void write(String msg) {
        LOGGER.trace("Writing message to console");
        System.out.print(msg);
    }

}
