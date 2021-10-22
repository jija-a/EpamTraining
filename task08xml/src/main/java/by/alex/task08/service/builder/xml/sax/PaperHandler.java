package by.alex.task08.service.builder.xml.sax;

import by.alex.task08.service.builder.PaperEnum;
import by.alex.task08.domain.Paper;
import by.alex.task08.domain.Magazine;
import by.alex.task08.domain.PaperGenre;
import by.alex.task08.domain.Newspaper;
import by.alex.task08.domain.Booklet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class PaperHandler extends DefaultHandler {

    /**
     * Class logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperHandler.class);

    /**
     * {@link Set} of papers.
     */
    private final Set<Paper> papers;

    /**
     * Current {@link Paper}.
     */
    private Paper current = null;

    /**
     * Current {@link PaperEnum} value.
     */
    private PaperEnum currentEnum = null;

    /**
     * Diapason of {@link PaperEnum} values where to search for tag.
     */
    private final EnumSet<PaperEnum> withText;

    /**
     * Public constructor.
     * <p>
     * Initializes papers set and enum diapason.
     * </p>
     */
    public PaperHandler() {
        this.papers = new HashSet<>();
        this.withText =
                EnumSet.range(PaperEnum.TITLE, PaperEnum.SUBSCRIPT_INDEX);
    }

    /**
     * Papers getter.
     *
     * @return {@link Set} of {@link Paper}
     */
    public Set<Paper> getPapers() {
        return this.papers;
    }

    /**
     * @see DefaultHandler
     */
    @Override
    public void startDocument() {
        LOGGER.info("Parsing started");
    }

    /**
     * @see DefaultHandler
     */
    @Override
    public void endDocument() {
        LOGGER.info("Parsing ended");
    }

    /**
     * Method runs when element occurs.
     * <p>
     * Defines if it entity or not. Than creates or set
     * entity values.
     * </p>
     *
     * @see DefaultHandler
     */
    @Override
    public void startElement(final String uri,
                             final String localName,
                             final String qName,
                             final Attributes attrs) {

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

    private void setCurrentAttributes(final Attributes attrs) {
        LOGGER.trace("Setting current attributes");
        current.setId(Long.valueOf(attrs.getValue(PaperEnum.ID.getValue())));
        current.setTitle(attrs.getValue(PaperEnum.TITLE.getValue()));
        if (attrs.getValue(PaperEnum.GENRE.getValue()) != null) {
            PaperGenre genre = PaperGenre
                    .resolveGenreByString(PaperEnum.GENRE.getValue());
            current.getChars().setGenre(genre);
        }
        if (attrs.getValue(PaperEnum.DATE_OF_ISSUE.getValue()) != null) {
            LocalDate date = LocalDate.parse(attrs
                    .getValue(PaperEnum.DATE_OF_ISSUE.getValue()));
            current.getChars().setDateOfIssue(date);
        }
        LOGGER.trace("Current: {}", current);
    }

    /**
     * @see DefaultHandler
     */
    @Override
    public void endElement(final String uri,
                           final String localName,
                           final String qName) {

        if (PaperEnum.NEWSPAPER.getValue().equals(qName)
                || PaperEnum.BOOKLET.getValue().equals(qName)
                || PaperEnum.MAGAZINE.getValue().equals(qName)) {
            papers.add(current);
            LOGGER.info("Current: {}, added to Set", current);
        }
    }

    /**
     * @see DefaultHandler
     */
    @Override
    public void characters(final char[] ch,
                           final int start,
                           final int length) {

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
