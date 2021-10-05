package com.epam.task07.service.sort;

import com.epam.task07.domain.TextComponent;
import com.epam.task07.service.sort.specification.Specification;

import java.util.ArrayList;
import java.util.List;

public class WordSortService extends AbstractSortService {

    @Override
    public TextComponent sort(TextComponent baseText,
                              Specification specification,
                              SortingType type) {

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
