package com.epam.task07.dao.parser.impl;

import com.epam.task07.dao.parser.TextParser;
import com.epam.task07.domain.Composite;
import com.epam.task07.domain.TextComponent;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordParser implements TextParser {

    /**
     * Logger of this class.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(WordParser.class);

    /**
     * Pattern to define if lexeme starts with punctuation symbol.
     */
    private static final String PUNCTUATION_START = "^\\p{Punct}\\D*$";

    /**
     * Pattern to define if lexeme ends with punctuation symbol.
     */
    private static final String PUNCTUATION_END = "^\\D*\\p{Punct}$";

    /**
     * Parser that will work after this.
     */
    private final TextParser successor;

    /**
     * Constructor of this class.
     *
     * @param parser - next parser
     */
    public WordParser(final TextParser parser) {
        this.successor = parser;
    }

    /**
     * Method to parse word.
     * Also defines if lexeme starts with punctuation.
     *
     * @param text - lexeme to parse
     */
    @Override
    public TextComponent parse(final String text) {
        LOGGER.info("Parsing word from lexeme: {}", text);
        StringBuilder builder = new StringBuilder(text);
        StringBuilder printBefore = new StringBuilder();
        StringBuilder printAfter = new StringBuilder();

        if (text.length() != 1 && !NumberUtils.isNumber(text)) {
            while (builder.toString().matches(PUNCTUATION_START)) {
                printBefore.insert(0, builder.charAt(0));
                builder.deleteCharAt(0);
                LOGGER.info("Left punctuation removed from '{}' - '{}'",
                        text, builder);
            }
            while (builder.toString().matches(PUNCTUATION_END)) {
                printAfter.insert(0, builder.charAt(builder.length() - 1));
                builder.deleteCharAt(builder.length() - 1);
                LOGGER.info("Right punctuation removed from '{}' - '{}'",
                        text, builder);
            }
        }

        printAfter.append(" ");
        TextComponent lexeme = new Composite(printBefore.toString(),
                printAfter.toString());
        TextComponent word = successor.parse(builder.toString());
        lexeme.add(word);

        LOGGER.info("Word parsed");
        return lexeme;
    }
}
