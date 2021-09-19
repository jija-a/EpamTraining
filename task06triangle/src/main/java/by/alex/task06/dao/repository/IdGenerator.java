package by.alex.task06.dao.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class IdGenerator {

    private static long id = 0L;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(IdGenerator.class);

    private IdGenerator() {
    }

    public static long generate() {
        long generatedId = ++id;
        LOGGER.info("Id generated: {}", generatedId);
        return generatedId;
    }
}
