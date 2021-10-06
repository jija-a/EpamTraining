package by.alex.task08.dao.parser.xml.sax;

import by.alex.task08.dao.parser.PaperEnum;
import by.alex.task08.domain.Booklet;
import by.alex.task08.domain.Magazine;
import by.alex.task08.domain.Newspaper;
import by.alex.task08.domain.Paper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class PaperHandler extends DefaultHandler {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperHandler.class);

    private final Set<Paper> papers;
    private Paper current = null;
    private PaperEnum currentEnum = null;
    private final EnumSet<PaperEnum> withText;

    public PaperHandler() {
        this.papers = new HashSet<>();
        this.withText = EnumSet.range(PaperEnum.PAPERS, PaperEnum.TITLE);
    }

    public Set<Paper> getPapers() {
        return this.papers;
    }

    @Override
    public void startDocument() {
        LOGGER.info("Parsing started");
    }

    @Override
    public void endDocument() {
        LOGGER.info("\nParsing ended");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        LOGGER.info(localName);
        if ("journal".equals(localName)) {
            current = new Booklet();
        } else if ("newspaper".equals(localName)) {
            current = new Newspaper();
        } else if ("magazine".equals(localName)) {
            current = new Magazine();
        } else {
            PaperEnum temp = PaperEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
        current.setId(Long.valueOf(attrs.getValue("id")));
        current.setTitle(attrs.getValue("title"));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("paper".equals(localName)) {
            papers.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length);
        LOGGER.info("Found string: {}", s);
        if (currentEnum != null) {
            switch (currentEnum) {
                case COLOR:
                    current.getChars().setColor(Boolean.parseBoolean(s));
                    break;
                case GLANCE:
                    current.getChars().setGlance(Boolean.parseBoolean(s));
                    break;
                case VOLUME:
                    current.getChars().setVolume(Integer.valueOf(s));
                    break;
                case MONTHLY:
                    current.getChars().setMonthly(Boolean.parseBoolean(s));
                    break;
                case INDEX:
                    LOGGER.info("Cached index: {}", s);
                    break;
                default:
                    LOGGER.info("Default switch");
            }
        }
    }
}
