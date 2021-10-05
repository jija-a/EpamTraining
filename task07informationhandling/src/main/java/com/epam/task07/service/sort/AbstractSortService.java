package com.epam.task07.service.sort;

import com.epam.task07.domain.TextComponent;
import com.epam.task07.service.SortService;
import com.epam.task07.service.sort.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSortService implements SortService {

    /**
     * Class logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(AbstractSortService.class);

    /**
     * Method add children to {@link TextComponent} component.
     *
     * @param component - where to add
     * @param children  - children to add
     */
    protected void addChildren(final TextComponent component,
                               final List<TextComponent> children) {

        LOGGER.trace("Adding children to component");
        for (TextComponent child : children) {
            component.add(child);
        }
    }

    /**
     * Method to remove children from component.
     *
     * @param component - component where to remove
     */
    protected void removeChildren(final TextComponent component) {

        LOGGER.trace("Removing children from component");
        int size = component.count();
        for (int i = size - 1; i >= 0; i--) {
            component.remove(component.getChild(i));
        }
    }

    /**
     * Method to get children from component.
     *
     * @param component - where to get
     * @return {@link List} {@link TextComponent} children
     */
    protected List<TextComponent> getChildren(final TextComponent component) {

        LOGGER.trace("Getting children from component");
        List<TextComponent> children = new ArrayList<>();
        for (int i = 0; i < component.count(); i++) {
            children.add(component.getChild(i));
        }
        return children;
    }

    /**
     * Method to sort list by specification.
     *
     * @param children      - list to sort
     * @param type          - type of sorting
     * @param specification - by specification
     */
    protected void sortWithTypeDefinition(final List<TextComponent> children,
                                          final SortingType type,
                                          final Specification specification) {

        LOGGER.trace("Sorting list by specification, sorting type - {}", type);
        if (type.equals(SortingType.ASC)) {
            children.sort(specification);
        } else {
            children.sort(specification.reversed());
        }
    }

}
