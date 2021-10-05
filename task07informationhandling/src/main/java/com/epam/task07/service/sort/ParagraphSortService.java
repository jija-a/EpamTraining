package com.epam.task07.service.sort;

import com.epam.task07.domain.TextComponent;
import com.epam.task07.service.sort.specification.Specification;

import java.util.List;

public class ParagraphSortService extends AbstractSortService {

    @Override
    public TextComponent sort(TextComponent baseText,
                              Specification specification,
                              SortingType type) {

        List<TextComponent> paragraphs = this.getChildren(baseText);
        this.sortWithTypeDefinition(paragraphs, type, specification);
        this.removeChildren(baseText);
        this.addChildren(baseText, paragraphs);

        return baseText;
    }
}
