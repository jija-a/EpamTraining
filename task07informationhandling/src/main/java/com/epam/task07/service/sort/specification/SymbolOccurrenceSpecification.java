package com.epam.task07.service.sort.specification;

import com.epam.task07.domain.TextComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SymbolOccurrenceSpecification implements Specification {

    /**
     * Class logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SymbolOccurrenceSpecification.class);

    /**
     * Symbol value.
     */
    private final char symbol;

    /**
     * Class constructor.
     *
     * @param c - symbol value
     */
    public SymbolOccurrenceSpecification(final char c) {
        this.symbol = c;
    }

    /**
     * Method to compare two {@link TextComponent} by symbol occurrence.
     *
     * @param o1 - first {@link TextComponent} to compare
     * @param o2 - second {@link TextComponent} to compare
     */
    @Override
    public int compare(final TextComponent o1,
                       final TextComponent o2) {

        LOGGER.trace("Comparing character occurrence in '{}' and '{}'"
                + "symbol is - {}", o1, o2, symbol);
        long counter1 = this.countCharacterOccurrence(o1);
        long counter2 = this.countCharacterOccurrence(o2);

        int result = Long.compare(counter1, counter2);

        if (result == 0) {
            LOGGER.trace("Character occurrence is identical,"
                    + " sorting by alphabet");
            String firstComponentText = o1.collect().toLowerCase();
            String secondComponentText = o2.collect().toLowerCase();
            result = firstComponentText.compareTo(secondComponentText);
        }

        return result;
    }

    private long countCharacterOccurrence(final TextComponent lexeme) {

        String lexemeText = lexeme.collect();
        return lexemeText.chars().filter(ch ->
                Character.toLowerCase(ch)
                        == Character.toLowerCase(symbol)).count();
    }
}
