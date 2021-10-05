package com.epam.task07;

import com.epam.task07.dao.ApplicationProperties;
import com.epam.task07.dao.DaoException;
import com.epam.task07.dao.parser.TextParser;
import com.epam.task07.dao.parser.impl.*;
import com.epam.task07.dao.reader.BaseFileReader;
import com.epam.task07.dao.reader.impl.BaseFileReaderImpl;
import com.epam.task07.dao.repository.TextStorage;
import com.epam.task07.domain.TextComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws DaoException {

        BaseFileReader reader = BaseFileReaderImpl.READER;
        String filePath = ApplicationProperties.PROPERTIES.getInputDir()
                + ApplicationProperties.PROPERTIES.getTextFileName();
        String originalText = reader.read(filePath);
        TextParser parser =
                new ParagraphParser(
                        new SentenceParser(
                                new LexemeParser(
                                        new WordParser(
                                                new SymbolParser()
                                        )
                                )
                        ));
        TextComponent parsedComponent = parser.parse(originalText);
        TextStorage.STORAGE.setText(parsedComponent);

        String text = TextStorage.STORAGE.getText().collect();
        LOGGER.info("Collected text:\n{}", text);
        /*        /////////////////////////////////////////////////////////////////////
        //Sorting by sentence qty
        SortService paragraphSortService = new ParagraphSortService();

        TextComponent sortedTextComponent =
                paragraphSortService.sort(TextStorage.STORAGE.getText(),
                        new LengthSpecification(),
                        SortService.SortingType.ASC);

        String sortedText = sortedTextComponent.collect();
        LOGGER.info("Sorted text:\n{}", sortedText);
        /////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////////////////////////////
        //Sorting by words length
        SortService wordSortService = new WordSortService();

        TextComponent sortedTextBySentences =
                wordSortService.sort(TextStorage.STORAGE.getText(),
                        new LengthSpecification(),
                        SortService.SortingType.ASC);

        String sortedTextSentences = sortedTextBySentences.collect();
        LOGGER.info("Sorted text:\n{}", sortedTextSentences);
        /////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////////////////////////////
        //Sorting by symbol occurrence
        SortService lexemeSortService = new LexemeSortService();

        TextComponent sortedTextBySymbol =
                lexemeSortService.sort(TextStorage.STORAGE.getText(),
                        new SymbolOccurrenceSpecification('e'),
                        SortService.SortingType.DESC);

        String collectedTextBySymbol = sortedTextBySymbol.collect();
        LOGGER.info("Sorted text:\n{}", collectedTextBySymbol);
        /////////////////////////////////////////////////////////////////////
        */
    }
}
