package com.epam.task07.dao.parser.impl;

import com.epam.task07.dao.parser.TextParser;
import com.epam.task07.domain.Composite;
import com.epam.task07.domain.TextComponent;
import com.epam.task07.domain.TextSymbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SymbolParser implements TextParser {

    /**
     * Logger of this class.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SymbolParser.class);

    /**
     * Method to parse symbols.
     *
     * @param text - word to parse
     */
    @Override
    public TextComponent parse(final String text) {
        LOGGER.info("Parsing symbols from word: {}", text);
        TextComponent word = new Composite();
        char[] chars = text.toCharArray();
        for (char aChar : chars) {
            TextComponent symbol = new TextSymbol(aChar);
            word.add(symbol);
        }

        LOGGER.trace("Symbols parsed");
        return word;
    }
}
