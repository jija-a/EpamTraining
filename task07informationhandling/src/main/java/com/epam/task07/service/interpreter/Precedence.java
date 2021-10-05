package com.epam.task07.service.interpreter;

import java.util.Map;

public final class Precedence {

    /**
     * Map of operation as a key and precedence level as a value.
     */
    private static final Map<String, Integer> OPERATION_PRECEDENCE = initMap();

    private Precedence() {
    }

    private static Map<String, Integer> initMap() {
        return Map.ofEntries(
                Map.entry("++", PrecedenceLvlConstant.FOURTEEN),
                Map.entry("--", PrecedenceLvlConstant.FOURTEEN),

                Map.entry("new", PrecedenceLvlConstant.THIRTEEN),

                Map.entry("*", PrecedenceLvlConstant.TWELVE),
                Map.entry("/", PrecedenceLvlConstant.TWELVE),
                Map.entry("%", PrecedenceLvlConstant.TWELVE),
                Map.entry("~", PrecedenceLvlConstant.TWELVE),

                Map.entry("+", PrecedenceLvlConstant.ELEVEN),
                Map.entry("-", PrecedenceLvlConstant.ELEVEN),

                Map.entry(">>", PrecedenceLvlConstant.TEN),
                Map.entry("<<", PrecedenceLvlConstant.TEN),
                Map.entry(">>>", PrecedenceLvlConstant.TEN),

                Map.entry("<", PrecedenceLvlConstant.NINE),
                Map.entry(">", PrecedenceLvlConstant.NINE),
                Map.entry("<=", PrecedenceLvlConstant.NINE),
                Map.entry(">=", PrecedenceLvlConstant.NINE),
                Map.entry("instanceof", PrecedenceLvlConstant.NINE),

                Map.entry("==", PrecedenceLvlConstant.EIGHT),
                Map.entry("!=", PrecedenceLvlConstant.EIGHT),

                Map.entry("&", PrecedenceLvlConstant.SEVEN),

                Map.entry("^", PrecedenceLvlConstant.SIX),

                Map.entry("|", PrecedenceLvlConstant.FIVE),

                Map.entry("&&", PrecedenceLvlConstant.FOUR),

                Map.entry("||", PrecedenceLvlConstant.THREE),

                Map.entry("?", PrecedenceLvlConstant.TWO),
                Map.entry(":", PrecedenceLvlConstant.TWO),

                Map.entry("=", PrecedenceLvlConstant.ONE),
                Map.entry("+=", PrecedenceLvlConstant.ONE),
                Map.entry("-=", PrecedenceLvlConstant.ONE),
                Map.entry("*=", PrecedenceLvlConstant.ONE),
                Map.entry("/=", PrecedenceLvlConstant.ONE),
                Map.entry("%=", PrecedenceLvlConstant.ONE),
                Map.entry("^=", PrecedenceLvlConstant.ONE),
                Map.entry("|=", PrecedenceLvlConstant.ONE),
                Map.entry("<<=", PrecedenceLvlConstant.ONE),
                Map.entry(">>=", PrecedenceLvlConstant.ONE),
                Map.entry(">>>=", PrecedenceLvlConstant.ONE)
        );
    }

    /**
     * Method to define operation precedence.
     *
     * @param c - operation
     * @return {@link Integer} precedence
     */
    public static int precedence(final String c) {
        return OPERATION_PRECEDENCE.getOrDefault(c, 0);
    }
}
