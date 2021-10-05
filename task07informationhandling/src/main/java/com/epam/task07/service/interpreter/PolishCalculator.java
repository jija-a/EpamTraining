package com.epam.task07.service.interpreter;

import java.util.List;

public class PolishCalculator {

    private static final String OPERATOR_PATTERN = "[~^&|]|(>>)|(<<)|(>>>)";
    private static final String NUMBER_PATTERN = "[0-9]+";

    private PolishCalculator() {
    }

    public static String calculate(List<String> postfix) throws InterpreterException {
        Context context = new Context();
        for (String symbol : postfix) {
            if (symbol.matches(OPERATOR_PATTERN)) {
                Expression expression = ExpressionCalculator.resolveExpression(symbol);
                expression.interpret(context);
            } else if (symbol.matches(NUMBER_PATTERN)) {
                context.pushValue(Integer.valueOf(symbol));
            } else {
                throw new InterpreterException("Unexpected operator: " + symbol);
            }
        }
        return String.valueOf(context.popValue());
    }
}
