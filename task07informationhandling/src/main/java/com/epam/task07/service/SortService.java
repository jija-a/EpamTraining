package com.epam.task07.service;

import com.epam.task07.domain.TextComponent;
import com.epam.task07.service.sort.specification.Specification;

public interface SortService {
    enum SortingType {
        /**
         * Incrementing.
         */
        ASC,
        /**
         * Decrementing.
         */
        DESC;
    }

    /**
     * Method to sort entities.
     *
     * @param baseText      - base text
     * @param specification - by what to sort
     * @param type          - sorting type
     * @return {@link TextComponent} sorted base text
     */
    TextComponent sort(TextComponent baseText,
                       Specification specification,
                       SortingType type);
}
