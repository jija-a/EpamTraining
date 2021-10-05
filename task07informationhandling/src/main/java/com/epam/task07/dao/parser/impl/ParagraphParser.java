package com.epam.task07.dao.parser.impl;

import com.epam.task07.dao.parser.TextParser;
import com.epam.task07.domain.Composite;
import com.epam.task07.domain.TextComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParagraphParser implements TextParser {

    /**
     * Logger of this class.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ParagraphParser.class);

    /**
     * Delimiter pattern to split paragraphs.
     */
    private static final String PARAGRAPH_DELIMITER = "\n";

    /**
     * Parser that will work after this parser.
     */
    private final TextParser successor;

    /**
     * Constructor of this class.
     *
     * @param parser - next parser
     */
    public ParagraphParser(final TextParser parser) {
        this.successor = parser;
    }

    /**
     * Method to parse paragraphs.
     *
     * @param text - base text
     */
    @Override
    public TextComponent parse(final String text) {
        LOGGER.info("Parsing paragraphs from text: {}", text);

        TextComponent baseText = new Composite();
        String[] paragraphs = text.split(PARAGRAPH_DELIMITER);
        for (String paragraphText : paragraphs) {
            if (!paragraphText.isBlank()) {
                TextComponent paragraph =
                        successor.parse(paragraphText.stripLeading());
                baseText.add(paragraph);
            }
        }

        LOGGER.info("Paragraphs parsed");
        return baseText;
    }
}
