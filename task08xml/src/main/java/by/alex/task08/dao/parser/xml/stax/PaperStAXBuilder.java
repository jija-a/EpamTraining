package by.alex.task08.dao.parser.xml.stax;

import by.alex.task08.dao.DaoException;
import by.alex.task08.dao.parser.xml.AbstractPaperBuilder;
import by.alex.task08.dao.parser.PaperEnum;
import by.alex.task08.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PaperStAXBuilder extends AbstractPaperBuilder {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperStAXBuilder.class);

    private final XMLInputFactory inputFactory;

    public PaperStAXBuilder() {
        this.inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetPapers(String filename) throws DaoException {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(filename)) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    PaperEnum tag = PaperEnum.resolveFiledByString(name);
                    switch (tag) {
                        case NEWSPAPER:
                            Paper paper = new Newspaper();
                            buildPaper(reader, paper);
                            this.getPapers().add(paper);
                            break;
                        case MAGAZINE:
                            paper = new Magazine();
                            buildPaper(reader, paper);
                            this.getPapers().add(paper);
                            break;
                        case BOOKLET:
                            paper = new Booklet();
                            buildPaper(reader, paper);
                            this.getPapers().add(paper);
                            break;
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            throw new DaoException("parsing error", e);
        } catch (IOException e) {
            throw new DaoException(filename + " is not found", e);
        }
    }

    private Paper buildPaper(XMLStreamReader reader, Paper paper) throws XMLStreamException {
        paper.setId(Long.valueOf(reader.getAttributeValue(null, PaperEnum.ID.getValue())));
        String genreText = reader.getAttributeValue(null, PaperEnum.GENRE.getValue());
        if (genreText != null) {
            PaperGenre genre = PaperGenre.resolveGenreByString(genreText);
            paper.getChars().setGenre(genre);
        }

        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    PaperEnum tag = PaperEnum.resolveFiledByString(name);
                    switch (tag) {
                        case TITLE:
                            paper.setTitle(getXMLText(reader));
                            break;
                        case IS_MONTHLY:
                            paper.getChars().setMonthly(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case IS_COLOR:
                            paper.getChars().setColor(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case VOLUME:
                            paper.getChars().setVolume(Integer.valueOf(getXMLText(reader)));
                            break;
                        case IS_GLANCE:
                            paper.getChars().setGlance(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case SUBSCRIPT_INDEX:
                            if (paper instanceof Newspaper) {
                                ((Newspaper) paper).setIndex(getXMLText(reader));
                            }
                            if (paper instanceof Magazine) {
                                ((Magazine) paper).setIndex(getXMLText(reader));
                            }
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    PaperEnum paperEnum = PaperEnum.resolveFiledByString(name);
                    if (PaperEnum.NEWSPAPER.equals(paperEnum)
                            || PaperEnum.MAGAZINE.equals(paperEnum)
                            || PaperEnum.BOOKLET.equals(paperEnum)) {
                        return paper;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Paper");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
