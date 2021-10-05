package com.epam.task07.service;

import com.epam.task07.domain.TextComponent;
import com.epam.task07.service.sort.specification.Specification;

public interface SortService {
    enum SortingType {
        ASC, DESC;
    }

    TextComponent sort(TextComponent baseText, Specification specification, SortingType type);
}
