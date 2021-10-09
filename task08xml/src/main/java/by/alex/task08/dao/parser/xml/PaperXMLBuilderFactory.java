package by.alex.task08.dao.parser.xml;

import by.alex.task08.dao.parser.xml.dom.PaperDOMBuilder;
import by.alex.task08.dao.parser.xml.sax.PaperSAXBuilder;
import by.alex.task08.dao.parser.xml.stax.PaperStAXBuilder;

public class PaperXMLBuilderFactory {

    /**
     * {@link PaperDOMBuilder}.
     */
    private final PaperDOMBuilder paperDOMBuilder;

    /**
     * {@link PaperSAXBuilder}.
     */
    private final PaperSAXBuilder paperSAXBuilder;

    /**
     * {@link PaperStAXBuilder}.
     */
    private final PaperStAXBuilder paperStAXBuilder;

    /**
     * Public constructor.
     */
    public PaperXMLBuilderFactory() {
        this.paperDOMBuilder = new PaperDOMBuilder();
        this.paperSAXBuilder = new PaperSAXBuilder();
        this.paperStAXBuilder = new PaperStAXBuilder();
    }

    /**
     * {@link PaperDOMBuilder} getter.
     *
     * @return {@link PaperDOMBuilder}
     */
    public PaperDOMBuilder getPaperDOMBuilder() {
        return paperDOMBuilder;
    }

    /**
     * {@link PaperSAXBuilder} getter.
     *
     * @return {@link PaperSAXBuilder}
     */
    public PaperSAXBuilder getPaperSAXBuilder() {
        return paperSAXBuilder;
    }

    /**
     * {@link PaperStAXBuilder} getter.
     *
     * @return {@link PaperStAXBuilder}
     */
    public PaperStAXBuilder getPaperStAXBuilder() {
        return paperStAXBuilder;
    }
}
