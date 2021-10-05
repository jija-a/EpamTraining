package com.epam.task07.service.interpreter;

import java.util.*;

public class InfixToPostfixConverter {

    private InfixToPostfixConverter() {
    }

    public static List<String> convert(String infix) {
        List<String> result = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder number = new StringBuilder();
        StringBuilder operator = new StringBuilder();

        for (int i = 0; i < infix.length(); ++i) {
            char symbol = infix.charAt(i);
            if (Character.isDigit(symbol)) {
                number.append(symbol);
            } else {
                if (!number.toString().trim().equals("")) {
                    result.add(number.toString());
                    number = new StringBuilder();
                }
                if (symbol == '(') {
                    stack.push(String.valueOf(symbol));
                } else if (symbol == ')') {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        result.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    if (symbol == '<' || symbol == '>') {
                        operator.append(symbol);
                        if (infix.charAt(i + 1) == '<' || infix.charAt(i + 1) == '>') {
                            continue;
                        }
                    } else {
                        operator.append(symbol);
                    }
                    while (!stack.isEmpty() &&
                            Precedence.precedence(operator.toString()) <= Precedence.precedence(stack.peek())) {
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

        return result;
    }
}
