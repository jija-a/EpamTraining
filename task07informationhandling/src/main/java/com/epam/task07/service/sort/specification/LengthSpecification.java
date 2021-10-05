package com.epam.task07.service.sort.specification;

import com.epam.task07.domain.TextComponent;

public class LengthSpecification implements Specification {

    /**
     * Compares {@link TextComponent} by count of children.
     *
     * @param o1 - first {@link TextComponent} to compare
     * @param o2 - second {@link TextComponent} to compare
     * @return {@link Integer}
     * @see java.util.Comparator
     */
    @Override
    public int compare(final TextComponent o1, final TextComponent o2) {
        return Integer.compare(o1.count(), o2.count());
    }
}
