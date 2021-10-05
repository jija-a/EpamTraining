package com.epam.task07.service.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public final class PolishCalculator {

    /**
     * Class logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(PolishCalculator.class);

    /**
     * Patter to define operation.
     */
    private static final String OPERATOR_PATTERN = "[~^&|]|(>>)|(<<)|(>>>)";

    /**
     * Pattern to define number.
     */
    private static final String NUMBER_PATTERN = "[0-9]+";

    /**
     * Private class constructor.
     */
    private PolishCalculator() {
    }

    /**
     * Method to calculate expression in reversed polish notation.
     *
     * @param postfix - polish expression
     * @return {@link String} result of calculation
     */
    public static String calculate(final List<String> postfix)
            throws InterpreterException {
        LOGGER.trace("Calculating reversed polish notation - '{}'", postfix);
        Context context = new Context();
        for (String symbol : postfix) {
            if (symbol.matches(OPERATOR_PATTERN)) {
                Expression expression = resolveExpression(symbol);
                expression.interpret(context);
            } else if (symbol.matches(NUMBER_PATTERN)) {
                context.pushValue(Integer.valueOf(symbol));
            } else {
                throw new InterpreterException("Unexpected operator: "
                        + symbol);
            }
        }
        int result = context.popValue();
        LOGGER.info("Result of calculating '{}' = {}", postfix, result);
        return String.valueOf(result);
    }

    private static Expression resolveExpression(final String operator) {
        Expression expression;
        LOGGER.trace("Defining operator '{}'", operator);
        switch (operator) {
            case "^":
                expression = context -> {
                    int b = context.popValue();
                    int a = context.popValue();
                    context.pushValue(a ^ b);
                };
                break;
            case ">>":
                expression = context -> {
                    int b = context.popValue();
                    int a = context.popValue();
                    context.pushValue(a >> b);
                };
                break;
            case ">>>":
                expression = context -> {
                    int b = context.popValue();
                    int a = context.popValue();
                    context.pushValue(a >>> b);
                };
                break;
            case "<<":
                expression = context -> {
                    int b = context.popValue();
                    int a = context.popValue();
                    context.pushValue(a << b);
                };
                break;
            case "~":
                expression = context -> {
                    int a = context.popValue();
                    context.pushValue(~a);
                };
                break;
            case "&":
                expression = context -> {
                    int b = context.popValue();
                    int a = context.popValue();
                    context.pushValue(a & b);
                };
                break;
            case "|":
                expression = context -> {
                    int b = context.popValue();
                    int a = context.popValue();
                    context.pushValue(a | b);
                };
                break;
            default:
                LOGGER.warn("Can't find an operator - '{}'", operator);
                throw new IllegalStateException("Unexpected value: "
                        + operator);
        }
        return expression;
    }
}
