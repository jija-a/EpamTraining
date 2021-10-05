package by.alex.task08.dao.parser.xml.sax;

import by.alex.task08.dao.parser.xml.PaperEnum;
import by.alex.task08.domain.Newspaper;
import by.alex.task08.domain.Paper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class PaperHandler extends DefaultHandler {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperHandler.class);

    private Set<Paper> papers;
    private Paper current = null;
    private PaperEnum currentEnum = null;
    private EnumSet<PaperEnum> withText;

    public PaperHandler() {
        this.papers = new HashSet<>();
        this.withText = EnumSet.range(PaperEnum.PAPERS, PaperEnum.TITLE);
    }

    public Set<Paper> getPapers() {
        return this.papers;
    }

    @Override
    public void startDocument() throws SAXException {
        LOGGER.info("Parsing started");
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.info("\nParsing ended");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        if ("paper".equals(localName)) {
            current = new Newspaper();
            current.setId(Long.valueOf(attrs.getValue("id")));
            if (attrs.getLength() == 2) {
                //current.setChars(attrs.getValue("Chars"));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("paper".equals(localName)) {
            papers.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String result = new String(ch, start, length);
    }
}
