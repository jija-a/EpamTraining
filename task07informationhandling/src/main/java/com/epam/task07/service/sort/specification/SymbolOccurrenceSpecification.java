package com.epam.task07.service.sort.specification;

import com.epam.task07.domain.TextComponent;

public class SymbolOccurrenceSpecification implements Specification {

    private final char symbol;

    public SymbolOccurrenceSpecification(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(TextComponent o1, TextComponent o2) {

        long counter1 = this.countCharacterOccurrence(o1);
        long counter2 = this.countCharacterOccurrence(o2);

        int result = Long.compare(counter1, counter2);

        if (result == 0) {
            String firstComponentText = o1.collect().toLowerCase();
            String secondComponentText = o2.collect().toLowerCase();
            result = firstComponentText.compareTo(secondComponentText);
        }

        return result;
    }

    private long countCharacterOccurrence(TextComponent lexeme) {

        String lexemeText = lexeme.collect();
        return lexemeText.chars().filter(ch ->
                Character.toLowerCase(ch) == Character.toLowerCase(symbol)).count();
    }
}
