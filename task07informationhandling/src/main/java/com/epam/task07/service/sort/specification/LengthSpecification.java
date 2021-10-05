package com.epam.task07.service.sort.specification;

import com.epam.task07.domain.TextComponent;

public class LengthSpecification implements Specification{

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return Integer.compare(o1.count(), o2.count());
    }
}
