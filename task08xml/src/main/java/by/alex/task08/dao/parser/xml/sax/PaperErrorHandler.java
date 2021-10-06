package by.alex.task08.dao.parser.xml.sax;

import by.alex.task08.domain.Paper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class PaperErrorHandler implements ErrorHandler {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperErrorHandler.ERROR_MSG);

    private static final String ERROR_MSG = "Line: {}, exception: ";

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        String lineColumnNumber = this.getLine(exception);
        LOGGER.warn(ERROR_MSG, lineColumnNumber, exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        String lineColumnNumber = this.getLine(exception);
        LOGGER.error(ERROR_MSG, lineColumnNumber, exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        String lineColumnNumber = this.getLine(exception);
        LOGGER.error(ERROR_MSG, lineColumnNumber, exception);
    }

    private String getLine(SAXParseException e) {
        return e.getLineNumber() + ":" + e.getColumnNumber();
    }
}
