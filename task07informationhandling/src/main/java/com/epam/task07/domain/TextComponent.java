package com.epam.task07.domain;

public interface TextComponent {

    /**
     * Method to add new child to children list.
     *
     * @param child - child
     */
    void add(TextComponent child);

    /**
     * Method to remove child from children list.
     *
     * @param child - child
     */
    void remove(TextComponent child);

    /**
     * Method to add new child to children list.
     *
     * @param index - child index
     * @return child {@link TextComponent}
     */
    TextComponent getChild(int index);

    /**
     * Method to count children qty in list.
     *
     * @return qty
     */
    int count();

    /**
     * Method to collect text components back to {@link String}.
     *
     * @return text {@link String}
     */
    String collect();
}
