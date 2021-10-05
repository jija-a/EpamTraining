package com.epam.task07.dao.parser.impl;

import com.epam.task07.dao.parser.TextParser;
import com.epam.task07.domain.Composite;
import com.epam.task07.domain.TextComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LexemeParser implements TextParser {

    /**
     * Logger of class.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(LexemeParser.class);

    /**
     * Delimiter pattern to split lexemes.
     */
    private static final String LEXEME_DELIMITER = "\\p{Blank}";

    /**
     * Parser that will work after this parser.
     */
    private final TextParser successor;

    /**
     * Constructor of class.
     *
     * @param parser - next parser
     */
    public LexemeParser(final TextParser parser) {
        this.successor = parser;
    }

    /**
     * Method to parse lexemes.
     *
     * @param text - sentence to parse
     */
    @Override
    public TextComponent parse(final String text) {
        LOGGER.info("Parsing lexemes from sentence: {}", text);
        String[] lexemes = text.split(LEXEME_DELIMITER);
        TextComponent sentence = new Composite();

        for (String lexemeText : lexemes) {
            TextComponent lexeme = successor.parse(lexemeText);
            sentence.add(lexeme);
        }
        LOGGER.trace("Lexemes parsed");
        return sentence;
    }
}
