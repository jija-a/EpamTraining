package com.epam.task07.dao.parser.impl;

import com.epam.task07.dao.parser.TextParser;
import com.epam.task07.domain.Composite;
import com.epam.task07.domain.TextComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SentenceParser implements TextParser {

    /**
     * Logger of this class.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SentenceParser.class);

    /**
     * Pattern to split sentences.
     */
    private static final String SENTENCE_PATTERN =
            "(?<=[a-zA-Z0-9а-яА-Я][.!?])\\s+";

    /**
     * Parser that will work after this parser.
     */
    private final TextParser successor;

    /**
     * Constructor of this class.
     *
     * @param parser - next parser
     */
    public SentenceParser(final TextParser parser) {
        this.successor = parser;
    }

    /**
     * Method to parse sentences.
     *
     * @param text - paragraph to parse
     */
    @Override
    public TextComponent parse(final String text) {
        LOGGER.info("Parsing sentences from paragraph: {}", text);
        String printBefore = "    ";
        String printAfter = "\n";
        TextComponent paragraph = new Composite(printBefore, printAfter);
        String[] sentences = text.split(SENTENCE_PATTERN);

        for (String sentenceText : sentences) {
            TextComponent sentence = successor.parse(sentenceText);
            paragraph.add(sentence);
        }

        LOGGER.info("Sentences parsed");
        return paragraph;
    }
}
