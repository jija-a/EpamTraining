package by.alex.task08.dao.parser.xml.sax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class PaperErrorHandler implements ErrorHandler {

    /**
     * Class logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperErrorHandler.class);

    /**
     * Message to print if exception occurs.
     */
    private static final String ERROR_MSG = "Line: {}, exception: ";

    /**
     * @see ErrorHandler
     */
    @Override
    public void warning(final SAXParseException exception) throws SAXException {
        String lineColumnNumber = this.getLine(exception);
        LOGGER.warn(ERROR_MSG, lineColumnNumber, exception);
    }

    /**
     * @see ErrorHandler
     */
    @Override
    public void error(final SAXParseException exception) throws SAXException {
        String lineColumnNumber = this.getLine(exception);
        LOGGER.error(ERROR_MSG, lineColumnNumber, exception);
    }

    /**
     * @see ErrorHandler
     */
    @Override
    public void fatalError(final SAXParseException exception)
            throws SAXException {

        String lineColumnNumber = this.getLine(exception);
        LOGGER.error(ERROR_MSG, lineColumnNumber, exception);
    }

    private String getLine(final SAXParseException e) {
        return e.getLineNumber() + ":" + e.getColumnNumber();
    }
}
