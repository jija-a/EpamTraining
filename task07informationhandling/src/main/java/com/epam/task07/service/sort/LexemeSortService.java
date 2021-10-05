package com.epam.task07.service.sort;

import com.epam.task07.domain.TextComponent;
import com.epam.task07.service.sort.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class LexemeSortService extends AbstractSortService {

    /**
     * Class logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(LexemeSortService.class);

    /**
     * Method to sort lexemes by specification.
     *
     * @param baseText      - Base text
     * @param specification - by what to sort
     * @param type          - sorting type
     * @return Sorted {@link TextComponent} base text
     */
    @Override
    public TextComponent sort(final TextComponent baseText,
                              final Specification specification,
                              final SortingType type) {
        LOGGER.trace("Sorting lexemes");
        List<TextComponent> lexemes = this.getLexemes(baseText);

        this.sortWithTypeDefinition(lexemes, type, specification);
        this.updateLexemes(baseText, lexemes);

        return baseText;
    }

    private List<TextComponent> getLexemes(final TextComponent baseText) {

        List<TextComponent> lexemes = new ArrayList<>();
        for (TextComponent paragraph : this.getChildren(baseText)) {
            for (TextComponent sentence : this.getChildren(paragraph)) {
                lexemes.addAll(this.getChildren(sentence));
            }
        }
        return lexemes;
    }

    private void updateLexemes(final TextComponent component,
                               final List<TextComponent> lexemes) {
        LOGGER.trace("Updating lexemes");
        int from = 0;
        int to = 0;
        for (int i = 0; i < component.count(); i++) {
            TextComponent paragraph = component.getChild(i);
            for (int j = 0; j < paragraph.count(); j++) {
                TextComponent sentence = paragraph.getChild(j);
                int sentenceSize = sentence.count();
                to += sentenceSize;

                List<TextComponent> lexemesToAdd = lexemes.subList(from, to);
                this.removeChildren(sentence);
                this.addChildren(sentence, lexemesToAdd);

                from += sentenceSize;
            }
        }
    }

}
