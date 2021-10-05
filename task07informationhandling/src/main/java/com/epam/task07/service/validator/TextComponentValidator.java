package com.epam.task07.service.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextComponentValidator {

    /**
     * Class logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TextComponentValidator.class);

    /**
     * Pattern to define if {@link String} is math expression.
     */
    private static final String MATH_PATTERN = "[^\\D]+[|^~&><]+";

    /**
     * Class instance. Singleton pattern.
     */
    public static final TextComponentValidator VALIDATOR =
            new TextComponentValidator();

    /**
     * Private class constructor. Singleton pattern.
     */
    private TextComponentValidator() {
    }

    /**
     * Method to define if {@link String} is math expression.
     *
     * @param text - {@link String} to define
     * @return true - if expression, false if not
     */
    public boolean isExpression(final String text) {
        LOGGER.trace("Validating if string is expression: {}", text);
        boolean result;
        Pattern pattern = Pattern.compile(MATH_PATTERN);
        Matcher matcher = pattern.matcher(text);

        result = matcher.find();
        LOGGER.trace("{} - is expression - {}", text, result);
        return result;
    }
}
