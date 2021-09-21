package by.alex.task06.dao.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class IdGenerator {

    /**
     * Static id for figures. Increases every time when
     * {@link by.alex.task06.domain.Figure} added to
     * {@link Repository}.
     */
    private static long id = 0L;

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(IdGenerator.class);

    /**
     * Private class constructor.
     */
    private IdGenerator() {
    }

    /**
     * Method which generates id for figures.
     *
     * @return {@link Long} id
     */
    public static long generate() {
        long generatedId = ++id;
        LOGGER.info("Id generated: {}", generatedId);
        return generatedId;
    }
}
