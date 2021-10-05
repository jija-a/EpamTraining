package by.alex.task08.dao.parser.xml.sax;

import by.alex.task08.domain.Paper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class PaperSAXBuilder {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperSAXBuilder.class);

    private Set<Paper> papers;
    private PaperHandler handler;
    private XMLReader reader;

    public PaperSAXBuilder() {
        handler = new PaperHandler();
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(handler);
        } catch (ParserConfigurationException e) {
            LOGGER.error("Parser configuration error: ", e);
        } catch (SAXException e) {
            LOGGER.error("SAX parser error: ", e);
        }
    }

    public Set<Paper> getPapers() {
        return this.papers;
    }

    public void buildSetPapers(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException e) {
            LOGGER.error("IO thread error: ", e);
        } catch (SAXException e) {
            LOGGER.error("SAX parser error: ", e);
        }
        papers = handler.getPapers();
    }
}
