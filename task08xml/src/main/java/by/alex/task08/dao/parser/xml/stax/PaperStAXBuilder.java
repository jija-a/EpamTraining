package by.alex.task08.dao.parser.xml.stax;

import by.alex.task08.dao.parser.PaperEnum;
import by.alex.task08.domain.Booklet;
import by.alex.task08.domain.Newspaper;
import by.alex.task08.domain.Paper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PaperStAXBuilder {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperStAXBuilder.class);

    private final Set<Paper> papers;
    private final XMLInputFactory inputFactory;

    public PaperStAXBuilder() {
        this.papers = new HashSet<>();
        this.inputFactory = XMLInputFactory.newInstance();
    }

    public Set<Paper> getPapers() {
        return this.papers;
    }

    public void buildSetPapers(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(fileName);
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (PaperEnum.valueOf(name.toUpperCase()) == PaperEnum.NEWSPAPER) {
                        Paper paper = buildPaper(reader);
                        papers.add(paper);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            LOGGER.error("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            LOGGER.error("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private Paper buildPaper(XMLStreamReader reader) throws XMLStreamException {
        Newspaper pp = new Newspaper();
        pp.setId(Long.valueOf(reader.getAttributeValue(null, PaperEnum.ID.getValue())));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                name = reader.getLocalName();
                switch (PaperEnum.valueOf(name.toUpperCase())) {
                    case TITLE:
                        pp.setTitle(getXMLText(reader));
                        break;
                    case SUBSCRIPT_INDEX:
                        name = getXMLText(reader);
                        pp.setIndex(name);
                        break;
                    /*case CHARS:
                        pp.set(getXMLAddress(reader));
                        break;*/
                }
            } else if (type == XMLStreamConstants.END_ELEMENT) {
                name = reader.getLocalName();
                if (PaperEnum.valueOf(name.toUpperCase()) == PaperEnum.NEWSPAPER) {
                    return pp;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private Paper.Chars getXMLAddress(XMLStreamReader reader) throws XMLStreamException {
        Paper.Chars chars = new Paper.Chars();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PaperEnum.valueOf(name.toUpperCase())) {
                        case IS_GLANCE:
                            chars.setGlance(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case VOLUME:
                            chars.setVolume(Integer.valueOf(getXMLText(reader)));
                            break;
                        case IS_MONTHLY:
                            chars.setMonthly(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case IS_COLOR:
                            chars.setColor(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PaperEnum.valueOf(name.toUpperCase()) == PaperEnum.CHARS) {
                        return chars;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
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
