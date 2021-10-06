package by.alex.task08.dao.parser.xml;

import by.alex.task08.dao.parser.xml.dom.PaperDOMBuilder;
import by.alex.task08.dao.parser.xml.sax.PaperSAXBuilder;
import by.alex.task08.dao.parser.xml.stax.PaperStAXBuilder;

public class PaperXMLBuilderFactory {

    private final AbstractPaperBuilder paperDOMBuilder;
    private final AbstractPaperBuilder paperSAXBuilder;
    private final AbstractPaperBuilder paperStAXBuilder;

    public PaperXMLBuilderFactory() {
        this.paperDOMBuilder = new PaperDOMBuilder();
        this.paperSAXBuilder = new PaperSAXBuilder();
        this.paperStAXBuilder = new PaperStAXBuilder();
    }

    public AbstractPaperBuilder getPaperDOMBuilder() {
        return paperDOMBuilder;
    }

    public AbstractPaperBuilder getPaperSAXBuilder() {
        return paperSAXBuilder;
    }

    public AbstractPaperBuilder getPaperStAXBuilder() {
        return paperStAXBuilder;
    }
}
