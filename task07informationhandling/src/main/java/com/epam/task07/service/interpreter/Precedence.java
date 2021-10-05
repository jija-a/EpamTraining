package com.epam.task07.service.interpreter;

import java.util.Map;

public class Precedence {

    private static final Map<String, Integer> OPERATION_PRECEDENCE = initMap();

    private Precedence(){
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

    public static int precedence(String c) {
        return OPERATION_PRECEDENCE.getOrDefault(c, 0);
    }
}
