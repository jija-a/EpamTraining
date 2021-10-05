package com.epam.task07.service.sort;

import com.epam.task07.domain.TextComponent;
import com.epam.task07.service.sort.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ParagraphSortService extends AbstractSortService {

    /**
     * Class logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ParagraphSortService.class);

    /**
     * Method to sort paragraphs by specification.
     *
     * @param baseText      - base text
     * @param specification - by what to sort
     * @param type          - sort type
     */
    @Override
    public TextComponent sort(final TextComponent baseText,
                              final Specification specification,
                              final SortingType type) {

        LOGGER.trace("Sorting paragraphs");
        List<TextComponent> paragraphs = this.getChildren(baseText);
        this.sortWithTypeDefinition(paragraphs, type, specification);
        this.removeChildren(baseText);
        this.addChildren(baseText, paragraphs);

        return baseText;
    }
}
