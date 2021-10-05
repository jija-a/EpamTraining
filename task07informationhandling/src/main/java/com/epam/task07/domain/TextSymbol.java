package com.epam.task07.domain;

public class TextSymbol implements TextComponent {

    /**
     * Message to print if operation is unsupported.
     */
    private static final String OPERATION_UNSUPPORTED =
            "Operation unsupported";

    /**
     * {@link Character} value.
     */
    private final char symbol;

    /**
     * Class constructor.
     *
     * @param symbolValue - value of symbol
     */
    public TextSymbol(final char symbolValue) {
        this.symbol = symbolValue;
    }

    /**
     * Method is unsupported because symbol has no further extension.
     * And can't have any children.
     *
     * @see TextComponent
     * @throws UnsupportedOperationException - cause method is unsupported
     */
    @Override
    public void add(final TextComponent child) {
        throw new UnsupportedOperationException(OPERATION_UNSUPPORTED);
    }

    /**
     * Method is unsupported because symbol has no further extension.
     * And can't have any children.
     *
     * @see TextComponent
     * @throws UnsupportedOperationException - cause method is unsupported
     */
    @Override
    public void remove(final TextComponent child) {
        throw new UnsupportedOperationException(OPERATION_UNSUPPORTED);
    }

    /**
     * Method is unsupported because symbol has no further extension.
     * And can't have any children.
     *
     * @see TextComponent
     * @throws UnsupportedOperationException - cause method is unsupported
     */
    @Override
    public TextComponent getChild(final int index) {
        throw new UnsupportedOperationException(OPERATION_UNSUPPORTED);
    }

    /**
     * @see TextComponent
     */
    @Override
    public int count() {
        return 1;
    }

    /**
     * @see TextComponent
     */
    @Override
    public String collect() {
        return String.valueOf(this.symbol);
    }

    /**
     * @see Object
     */
    @Override
    public String toString() {
        return "TextSymbol{"
                + "symbol=" + symbol
                + '}';
    }
}
