package com.epam.task07.service.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public final class ExpressionCalculator {

    /**
     * Class logger.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ExpressionCalculator.class);

    /**
     * Class constructor.
     */
    private ExpressionCalculator() {
    }

    /**
     * Method that calculates expression.
     *
     * @param expression - {@link String} expression
     * @return {@link String} result of calculating
     */
    public static String calculate(final String expression)
            throws InterpreterException {

        LOGGER.info("Calculating expression - {}", expression);
        List<String> postfix = InfixToPostfixConverter.convert(expression);
        return PolishCalculator.calculate(postfix);
    }
}
