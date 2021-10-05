package com.epam.task07.dao.repository;

import com.epam.task07.domain.Composite;
import com.epam.task07.domain.TextComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TextStorage {

    /**
     * Logger of this class.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TextStorage.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final TextStorage STORAGE = new TextStorage();

    /**
     * Storing component.
     */
    private TextComponent component;

    private TextStorage() {
    }

    /**
     * Method to get storing text component.
     *
     * @return new {@link TextComponent} instance with storing components
     */
    public TextComponent getText() {
        LOGGER.trace("Returning new Composite instance");
        return new Composite(component);
    }

    /**
     * Method to set storage component.
     *
     * @param text - {@link TextComponent} instance
     */
    public void setText(final TextComponent text) {
        this.component = text;
    }
}
