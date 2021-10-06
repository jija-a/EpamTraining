package by.alex.task08.dao.parser.xml.dom;

import by.alex.task08.dao.DaoException;
import by.alex.task08.dao.parser.xml.AbstractPaperBuilder;
import by.alex.task08.dao.parser.PaperEnum;
import by.alex.task08.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PaperDOMBuilder extends AbstractPaperBuilder {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperDOMBuilder.class);

    private DocumentBuilder docBuilder;

    public PaperDOMBuilder() {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Parser config exception: ", e);
        }
    }

    @Override
    public void buildSetPapers(String fileName) throws DaoException {
        Document doc;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            this.buildSpecificPapers(root, PaperEnum.BOOKLET);
            this.buildSpecificPapers(root, PaperEnum.MAGAZINE);
            this.buildSpecificPapers(root, PaperEnum.NEWSPAPER);
        } catch (SAXException e) {
            throw new DaoException("Parsing failure: ", e);
        } catch (IOException e) {
            throw new DaoException("File error or I/O error: ", e);
        }
    }

    private void buildSpecificPapers(Element root, PaperEnum paperEnum) {
        NodeList papersList = root.getElementsByTagName(paperEnum.getValue());
        for (int i = 0; i < papersList.getLength(); i++) {
            Element paperElement = (Element) papersList.item(i);
            Paper paper = buildPaper(paperElement, paperEnum);
            this.getPapers().add(paper);
        }
    }

    private Paper buildPaper(Element paperElement, PaperEnum paperEnum) {
        Paper paper = null;
        if (PaperEnum.MAGAZINE.equals(paperEnum)) {
            paper = new Magazine();
        } else if (PaperEnum.BOOKLET.equals(paperEnum)) {
            paper = new Booklet();
        } else {
            paper = new Newspaper();
        }

        LOGGER.info("Setting 'paper' fields");
        paper.setId(Long.valueOf(paperElement.getAttribute(PaperEnum.ID.getValue())));
        paper.setTitle(getElementTextContent(
                paperElement, PaperEnum.TITLE.getValue()));
        Paper.Chars chars = paper.getChars();

        LOGGER.info("Setting 'Chars' fields");
        chars.setMonthly(Boolean.parseBoolean(getElementTextContent(paperElement, PaperEnum.IS_MONTHLY.getValue())));
        chars.setGlance(Boolean.parseBoolean(getElementTextContent(paperElement, PaperEnum.IS_GLANCE.getValue())));
        chars.setColor(Boolean.parseBoolean(getElementTextContent(paperElement, PaperEnum.IS_COLOR.getValue())));
        chars.setVolume(Integer.valueOf(getElementTextContent(paperElement, PaperEnum.VOLUME.getValue())));

        if (paperElement.getElementsByTagName(PaperEnum.GENRE.getValue()) != null) {
            String genreStr = paperElement.getAttribute(PaperEnum.GENRE.getValue());
            PaperGenre genre = PaperGenre.resolveGenreByString(genreStr);
            chars.setGenre(genre);
        }

        if (paper instanceof Magazine) {
            ((Magazine) paper).setIndex(getElementTextContent(paperElement, PaperEnum.TITLE.getValue()));
        } else if (paper instanceof Newspaper) {
            ((Newspaper) paper).setIndex(getElementTextContent(paperElement, PaperEnum.TITLE.getValue()));
        }
        return paper;
    }

    private static String getElementTextContent(Element element, String elementName) {
        LOGGER.info("Getting element by element name - '{}'", elementName);
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
