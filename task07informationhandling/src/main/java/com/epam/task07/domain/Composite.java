package com.epam.task07.domain;

import com.epam.task07.service.interpreter.ExpressionCalculator;
import com.epam.task07.service.interpreter.InterpreterException;
import com.epam.task07.service.validator.TextComponentValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Composite implements TextComponent {

    /**
     * Logger of this class.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(Composite.class);

    /**
     * List of children. Same as this component.
     * Composite pattern.
     */
    private final List<TextComponent> children;

    /**
     * {@link String} that need to print before main text.
     */
    private String printBefore;

    /**
     * {@link String} that need to print after main text.
     */
    private String printAfter;

    /**
     * Empty class constructor. Initializes children list.
     */
    public Composite() {
        this.children = new ArrayList<>();
    }

    /**
     * Class constructor. Initializes children list.
     * Also set what to print before and after main text.
     *
     * @param before - what to print before
     * @param after  - what to print after
     */
    public Composite(final String before, final String after) {
        this.children = new ArrayList<>();
        this.printBefore = before;
        this.printAfter = after;
    }

    /**
     * Class constructor. Initializes children list
     * with another {@link TextComponent} children list.
     *
     * @param text - {@link TextComponent} to copy
     */
    public Composite(final TextComponent text) {
        List<TextComponent> original = new ArrayList<>();
        for (int i = 0; i < text.count(); i++) {
            TextComponent paragraph = text.getChild(i);
            original.add(paragraph);
        }
        this.children = original;
    }

    /**
     * @see TextComponent
     */
    @Override
    public void add(final TextComponent child) {
        children.add(child);
    }

    /**
     * @see TextComponent
     */
    @Override
    public void remove(final TextComponent child) {
        children.remove(child);
    }

    /**
     * @see TextComponent
     */
    @Override
    public TextComponent getChild(final int index) {
        return children.get(index);
    }

    /**
     * @see TextComponent
     */
    @Override
    public int count() {
        return children.size();
    }

    /**
     * @see Object
     */
    @Override
    public String toString() {
        return "Composite{"
                + "children=" + children
                + ", printBefore='" + printBefore + '\''
                + ", printAfter='" + printAfter + '\''
                + '}';
    }

    /**
     * @see TextComponent
     */
    @Override
    public String collect() {

        StringBuilder builder = new StringBuilder();
        for (TextComponent child : children) {
            String childText = child.collect();
            builder.append(childText);
        }
        String text = builder.toString();

        if (TextComponentValidator.VALIDATOR.isExpression(text)) {
            try {
                text = ExpressionCalculator.calculate(text);
            } catch (InterpreterException e) {
                LOGGER.error("Interpreter throws exception: ", e);
            }
        }

        this.setBefore();
        this.setAfter();
        return printBefore + text + printAfter;
    }

    private void setBefore() {
        if (this.printBefore == null) {
            this.printBefore = "";
        }
    }

    private void setAfter() {
        if (this.printAfter == null) {
            this.printAfter = "";
        }
    }

}
