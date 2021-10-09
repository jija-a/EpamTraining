package by.alex.task08.dao.parser.xml.stax;

import by.alex.task08.dao.DaoException;
import by.alex.task08.dao.parser.xml.AbstractPaperBuilder;
import by.alex.task08.dao.parser.PaperEnum;
import by.alex.task08.domain.Paper;
import by.alex.task08.domain.Magazine;
import by.alex.task08.domain.PaperGenre;
import by.alex.task08.domain.Newspaper;
import by.alex.task08.domain.Booklet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class PaperStAXBuilder extends AbstractPaperBuilder {

    /**
     * Class logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperStAXBuilder.class);

    /**
     * {@link XMLInputFactory}.
     */
    private final XMLInputFactory inputFactory;

    /**
     * Public constructor.
     */
    public PaperStAXBuilder() {
        this.inputFactory = XMLInputFactory.newInstance();
    }

    /**
     * @see AbstractPaperBuilder
     */
    @Override
    public void buildSetPapers(final String filename) throws DaoException {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(filename)) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    PaperEnum tag = PaperEnum.resolveFiledByString(name);
                    Paper paper = null;
                    switch (tag) {
                        case NEWSPAPER:
                            paper = new Newspaper();
                            break;
                        case MAGAZINE:
                            paper = new Magazine();
                            break;
                        case BOOKLET:
                            paper = new Booklet();
                            break;
                        default:
                            LOGGER.info("Tag: {}, is not an entity", tag);
                            break;
                    }
                    if (paper != null) {
                        buildPaper(reader, paper);
                        this.getPapers().add(paper);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            throw new DaoException("parsing error", e);
        } catch (IOException e) {
            throw new DaoException(filename + " is not found", e);
        }
    }

    private void buildPaper(final XMLStreamReader reader, final Paper paper)
            throws XMLStreamException {

        buildPaperAttributes(reader, paper);
        buildPaperElements(reader, paper);
    }

    private void buildPaperElements(final XMLStreamReader reader,
                                    final Paper paper)
            throws XMLStreamException {

        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                name = reader.getLocalName();
                PaperEnum tag = PaperEnum.resolveFiledByString(name);
                switch (tag) {
                    case TITLE:
                        paper.setTitle(getXMLText(reader));
                        break;
                    case IS_MONTHLY:
                        paper.getChars()
                                .setMonthly(Boolean.parseBoolean(
                                        getXMLText(reader)));
                        break;
                    case IS_COLOR:
                        paper.getChars()
                                .setColor(Boolean.parseBoolean(
                                        getXMLText(reader)));
                        break;
                    case VOLUME:
                        paper.getChars()
                                .setVolume(Integer.valueOf(
                                        getXMLText(reader)));
                        break;
                    case IS_GLANCE:
                        paper.getChars()
                                .setGlance(Boolean.parseBoolean(
                                        getXMLText(reader)));
                        break;
                    case SUBSCRIPT_INDEX:
                        if (paper instanceof Newspaper) {
                            ((Newspaper) paper).setIndex(getXMLText(reader));
                        }
                        if (paper instanceof Magazine) {
                            ((Magazine) paper).setIndex(getXMLText(reader));
                        }
                        break;
                    default:
                        LOGGER.info("Default switch value: {}", tag);
                        break;
                }
                break;
            }
        }
    }

    private void buildPaperAttributes(final XMLStreamReader reader,
                                      final Paper paper) {

        paper.setId(Long.valueOf(
                reader.getAttributeValue(null, PaperEnum.ID.getValue())));

        String genreText =
                reader.getAttributeValue(null, PaperEnum.GENRE.getValue());
        if (genreText != null) {
            PaperGenre genre = PaperGenre.resolveGenreByString(genreText);
            paper.getChars().setGenre(genre);
        }

        String dateText = reader
                .getAttributeValue(null, PaperEnum.DATE_OF_ISSUE.getValue());
        if (dateText != null) {
            LocalDate date = LocalDate.parse(dateText);
            paper.getChars().setDateOfIssue(date);
        }
    }

    private String getXMLText(final XMLStreamReader reader)
            throws XMLStreamException {

        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
