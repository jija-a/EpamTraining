package com.epam.task07.service.sort;

import com.epam.task07.domain.TextComponent;
import com.epam.task07.service.sort.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class WordSortService extends AbstractSortService {

    /**
     * Class logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(WordSortService.class);

    /**
     * Method to sort {@link TextComponent} by specification.
     *
     * @param baseText      - base text
     * @param specification - by what to sort
     * @param type          - sorting type
     */
    @Override
    public TextComponent sort(final TextComponent baseText,
                              final Specification specification,
                              final SortingType type) {

        LOGGER.trace("Sorting words");
        int counter = 0;
        for (int i = 0; i < baseText.count(); i++) {
            TextComponent paragraph = baseText.getChild(i);
            for (int j = 0; j < paragraph.count(); j++) {
                TextComponent sentence = paragraph.getChild(j);
                List<TextComponent> words = new ArrayList<>();

                for (int k = 0; k < sentence.count(); k++) {
                    TextComponent lexeme = sentence.getChild(k);
                    words.add(lexeme.getChild(0));
                }

                this.sortWithTypeDefinition(words, type, specification);

                for (int k = 0; k < sentence.count(); k++) {
                    TextComponent lexeme = sentence.getChild(k);
                    lexeme.remove(lexeme.getChild(0));
                    lexeme.add(words.get(counter));
                    counter++;
                }
                counter = 0;
            }
        }

        return baseText;
    }
}
