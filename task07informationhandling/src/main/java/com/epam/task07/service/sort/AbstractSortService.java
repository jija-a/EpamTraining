package com.epam.task07.service.sort;

import com.epam.task07.domain.TextComponent;
import com.epam.task07.service.SortService;
import com.epam.task07.service.sort.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSortService implements SortService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AbstractSortService.class);

    protected void addChildren(final TextComponent component,
                               final List<TextComponent> children) {

        LOGGER.info("Adding children to component");
        for (TextComponent child : children) {
            component.add(child);
        }
    }

    protected void removeChildren(final TextComponent component) {

        LOGGER.info("Removing children from component");
        int size = component.count();
        for (int i = size - 1; i >= 0; i--) {
            component.remove(component.getChild(i));
        }
    }

    protected List<TextComponent> getChildren(final TextComponent component) {

        LOGGER.info("Getting children from component");
        List<TextComponent> children = new ArrayList<>();
        for (int i = 0; i < component.count(); i++) {
            children.add(component.getChild(i));
        }
        return children;
    }

    protected void sortWithTypeDefinition(final List<TextComponent> children,
                                          final SortingType type,
                                          final Specification specification) {

        LOGGER.info("Sorting list by specification, sorting type - {}", type);
        if (type.equals(SortingType.ASC)) {
            children.sort(specification);
        } else {
            children.sort(specification.reversed());
        }
    }
}
