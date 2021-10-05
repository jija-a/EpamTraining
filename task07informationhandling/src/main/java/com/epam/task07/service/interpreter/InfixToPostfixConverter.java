package com.epam.task07.service.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public final class InfixToPostfixConverter {

    /**
     * Class logger.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(InfixToPostfixConverter.class);

    /**
     * Private class constructor.
     */
    private InfixToPostfixConverter() {
    }

    /**
     * Method to convert infix notation to postfix.
     *
     * @param infix - {@link String} expression
     * @return {@link List} of {@link String} numbers and operations
     * in postfix
     */
    public static List<String> convert(final String infix) {
        LOGGER.trace("Converting infix - {} to postfix", infix);
        List<String> result = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder number = new StringBuilder();
        StringBuilder operator = new StringBuilder();

        for (int i = 0; i < infix.length(); ++i) {
            char symbol = infix.charAt(i);
            LOGGER.trace("Got character - '{}'", symbol);
            if (Character.isDigit(symbol)) {
                LOGGER.trace("Symbol - '{}' is digit", symbol);
                number.append(symbol);
            } else {
                if (!number.toString().trim().equals("")) {
                    result.add(number.toString());
                    number = new StringBuilder();
                }
                if (symbol == '(') {
                    LOGGER.trace("Symbol - '{}' is parentheses", symbol);
                    stack.push(String.valueOf(symbol));
                } else if (symbol == ')') {
                    LOGGER.trace("Symbol - '{}' is parentheses", symbol);
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        result.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    if (symbol == '<' || symbol == '>') {
                        LOGGER.trace("Symbol - '{}' is shift", symbol);
                        operator.append(symbol);
                        if (infix.charAt(i + 1) == '<'
                                || infix.charAt(i + 1) == '>') {
                            continue;
                        }
                    } else {
                        operator.append(symbol);
                    }
                    while (!stack.isEmpty()
                            && Precedence.precedence(operator.toString())
                            <= Precedence.precedence(stack.peek())) {
                        result.add(stack.pop());
                    }
                    stack.push(operator.toString());
                    operator = new StringBuilder();
                }
            }
        }

        if (!number.toString().trim().equals("")) {
            result.add(number.toString());
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        LOGGER.info("Infix - '{}' converted - '{}'", infix, result);
        return result;
    }
}
