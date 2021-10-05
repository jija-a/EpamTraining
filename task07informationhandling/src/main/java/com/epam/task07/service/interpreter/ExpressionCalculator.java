package com.epam.task07.service.interpreter;

import java.util.List;

public class ExpressionCalculator {

    private ExpressionCalculator() {
    }

    public static String calculate(String expression) throws InterpreterException {
        List<String> postfix = InfixToPostfixConverter.convert(expression);
        return PolishCalculator.calculate(postfix);
    }

    public static Expression resolveExpression(String operator) {
        Expression expression = null;

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
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return expression;
    }
}
