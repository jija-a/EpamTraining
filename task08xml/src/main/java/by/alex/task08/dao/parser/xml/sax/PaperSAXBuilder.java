package by.alex.task08.dao.parser.xml.sax;

import by.alex.task08.dao.DaoException;
import by.alex.task08.dao.parser.xml.AbstractPaperBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class PaperSAXBuilder extends AbstractPaperBuilder {

    /**
     * Class logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperSAXBuilder.class);

    /**
     * {@link PaperHandler}.
     */
    private final PaperHandler contentHandler;

    /**
     * {@link XMLReader}.
     */
    private XMLReader reader;

    /**
     * Public constructor.
     */
    public PaperSAXBuilder() {
        super();
        contentHandler = new PaperHandler();
        PaperErrorHandler errorHandler = new PaperErrorHandler();
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(contentHandler);
            reader.setErrorHandler(errorHandler);
        } catch (ParserConfigurationException e) {
            LOGGER.error("Parser configuration error: ", e);
        } catch (SAXException e) {
            LOGGER.error("SAX parser error: ", e);
        }
    }

    /**
     * @see AbstractPaperBuilder
     */
    @Override
    public void buildSetPapers(final String fileName) throws DaoException {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            throw new DaoException("Parsing failure: ", e);
        } catch (IOException e) {
            throw new DaoException("File error or I/O error: ", e);
        }
        this.getPapers().addAll(contentHandler.getPapers());
    }
}
