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
                Map.entry("++", 14),
                Map.entry("--", 14),

                Map.entry("new", 13),

                Map.entry("*", 12),
                Map.entry("/", 12),
                Map.entry("%", 12),
                Map.entry("~", 12),

                Map.entry("+", 11),
                Map.entry("-", 11),

                Map.entry(">>", 10),
                Map.entry("<<", 10),
                Map.entry(">>>", 10),

                Map.entry("<", 9),
                Map.entry(">", 9),
                Map.entry("<=", 9),
                Map.entry(">=", 9),
                Map.entry("instanceof", 9),

                Map.entry("==", 8),
                Map.entry("!=", 8),

                Map.entry("&", 7),

                Map.entry("^", 6),

                Map.entry("|", 5),

                Map.entry("&&", 4),

                Map.entry("||", 3),

                Map.entry("?", 2),
                Map.entry(":", 2),

                Map.entry("=", 1),
                Map.entry("+=", 1),
                Map.entry("-=", 1),
                Map.entry("*=", 1),
                Map.entry("/=", 1),
                Map.entry("%=", 1),
                Map.entry("^=", 1),
                Map.entry("|=", 1),
                Map.entry("<<=", 1),
                Map.entry(">>=", 1),
                Map.entry(">>>=", 1)
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
