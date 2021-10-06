package by.alex.task08.dao.parser.xml.sax;

import by.alex.task08.dao.parser.PaperEnum;
import by.alex.task08.domain.*;
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
        this.withText = EnumSet.range(PaperEnum.TITLE, PaperEnum.SUBSCRIPT_INDEX);
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
        LOGGER.info("Parsing ended");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        LOGGER.trace("qName: {}", qName);
        if (PaperEnum.BOOKLET.getValue().equals(qName)) {
            current = new Booklet();
            this.setCurrentAttributes(attrs);
        } else if (PaperEnum.NEWSPAPER.getValue().equals(qName)) {
            current = new Newspaper();
            this.setCurrentAttributes(attrs);
        } else if (PaperEnum.MAGAZINE.getValue().equals(qName)) {
            current = new Magazine();
            this.setCurrentAttributes(attrs);
        } else {
            PaperEnum temp = PaperEnum.resolveFiledByString(qName);
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    private void setCurrentAttributes(Attributes attrs) {
        LOGGER.trace("Setting current attributes");
        current.setId(Long.valueOf(attrs.getValue(PaperEnum.ID.getValue())));
        current.setTitle(attrs.getValue(PaperEnum.TITLE.getValue()));
        if (attrs.getValue(PaperEnum.GENRE.getValue()) != null) {
            PaperGenre genre = PaperGenre.resolveGenreByString(attrs.getValue(1));
            current.getChars().setGenre(genre);
        }
        LOGGER.trace("Current: {}", current);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (PaperEnum.NEWSPAPER.getValue().equals(qName)
                || PaperEnum.BOOKLET.getValue().equals(qName)
                || PaperEnum.MAGAZINE.getValue().equals(qName)) {
            papers.add(current);
            LOGGER.info("Current: {}, added to Set", current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            LOGGER.trace("Current enum: {}", currentEnum);
            switch (currentEnum) {
                case TITLE:
                    LOGGER.trace("S = '{}'; Title switch", s);
                    current.setTitle(s);
                    break;
                case IS_COLOR:
                    LOGGER.trace("S = '{}'; Color switch", s);
                    current.getChars().setColor(Boolean.parseBoolean(s));
                    break;
                case IS_GLANCE:
                    LOGGER.trace("S = '{}'; Glance switch", s);
                    current.getChars().setGlance(Boolean.parseBoolean(s));
                    break;
                case VOLUME:
                    LOGGER.trace("S = '{}'; Volume switch", s);
                    current.getChars().setVolume(Integer.valueOf(s));
                    break;
                case IS_MONTHLY:
                    LOGGER.trace("S = '{}'; Monthly switch", s);
                    current.getChars().setMonthly(Boolean.parseBoolean(s));
                    break;
                case SUBSCRIPT_INDEX:
                    LOGGER.trace("S = '{}'; Index switch", s);
                    if (current instanceof Magazine) {
                        ((Magazine) current).setIndex(s);
                    }
                    if (current instanceof Newspaper) {
                        ((Newspaper) current).setIndex(s);
                    }
                    break;
                default:
                    LOGGER.warn("S = '{}'; Default switch", s);
            }
        }
        currentEnum = null;
    }
}
