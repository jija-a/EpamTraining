package by.alex.task08.dao.parser.xml.sax;

import by.alex.task08.domain.Paper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXParseException;

public class PaperErrorHandler {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperErrorHandler.ERROR_MSG);

    private static final String ERROR_MSG = "Line: {}, exception: ";

    public void warning(SAXParseException e) {
        String lineColumnNumber = this.getLine(e);
        LOGGER.warn(ERROR_MSG, lineColumnNumber, e);
    }

    public void error(SAXParseException e) {
        String lineColumnNumber = this.getLine(e);
        LOGGER.error(ERROR_MSG, lineColumnNumber, e);
    }

    public void fatalError(SAXParseException e) {
        String line = this.getLine(e);
        LOGGER.error(ERROR_MSG, line, e);
    }

    private String getLine(SAXParseException e) {
        return e.getLineNumber() + ":" + e.getColumnNumber();
    }
}
