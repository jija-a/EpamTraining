package com.epam.task07.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextComponentValidator {

    /**
     * Pattern to define if {@link String} is math expression.
     */
    private static final String MATH_PATTERN = "^?(\\d)[\\d+*/().,~><|&]+$";

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
        Pattern pattern = Pattern.compile(MATH_PATTERN);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}
