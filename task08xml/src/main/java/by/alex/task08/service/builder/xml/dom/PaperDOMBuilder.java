package by.alex.task08.service.builder.xml.dom;

import by.alex.task08.dao.DaoException;
import by.alex.task08.service.builder.PaperEnum;
import by.alex.task08.service.builder.xml.AbstractPaperBuilder;
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
import java.time.LocalDate;

public class PaperDOMBuilder extends AbstractPaperBuilder {

    /**
     * Class logger.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperDOMBuilder.class);

    /**
     * Document builder.
     *
     * @see DocumentBuilder
     */
    private DocumentBuilder docBuilder;

    /**
     * Public constructor.
     */
    public PaperDOMBuilder() {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Parser config exception: ", e);
        }
    }

    /**
     * Method to build {@link java.util.Set} if {@link Paper}.
     *
     * @param fileName - name of xml file
     * @see AbstractPaperBuilder
     */
    @Override
    public void buildSetPapers(final String fileName) throws DaoException {
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

    private void buildSpecificPapers(final Element root,
                                     final PaperEnum paperEnum) {

        NodeList papersList = root.getElementsByTagName(paperEnum.getValue());
        for (int i = 0; i < papersList.getLength(); i++) {
            Element paperElement = (Element) papersList.item(i);
            Paper paper = buildPaper(paperElement, paperEnum);
            this.papers.add(paper);
        }
    }

    private Paper buildPaper(final Element paperElement,
                             final PaperEnum paperEnum) {
        LOGGER.info("Building paper instance");
        Paper paper;
        if (PaperEnum.MAGAZINE.equals(paperEnum)) {
            LOGGER.trace("Paper is 'magazine'");
            paper = new Magazine();
        } else if (PaperEnum.BOOKLET.equals(paperEnum)) {
            LOGGER.trace("Paper is 'booklet'");
            paper = new Booklet();
        } else {
            LOGGER.trace("Paper is 'newspaper'");
            paper = new Newspaper();
        }

        LOGGER.trace("Getting 'paper' fields");
        String id = paperElement.getAttribute(PaperEnum.ID.getValue());
        String title = getElementTextContent(paperElement,
                PaperEnum.TITLE.getValue());
        String monthly = getElementTextContent(paperElement,
                PaperEnum.IS_MONTHLY.getValue());
        String glance = getElementTextContent(paperElement,
                PaperEnum.IS_GLANCE.getValue());
        String color = getElementTextContent(paperElement,
                PaperEnum.IS_COLOR.getValue());
        String volume = getElementTextContent(paperElement,
                PaperEnum.VOLUME.getValue());
        String date = getElementTextContent(paperElement,
                PaperEnum.DATE_OF_ISSUE.getValue());
        String genre = paperElement
                .getAttribute(PaperEnum.GENRE.getValue());

        String index = getElementTextContent(paperElement,
                PaperEnum.SUBSCRIPT_INDEX.getValue());

        LOGGER.trace("Setting 'paper' fields");
        paper.setId(Long.valueOf(id));
        paper.setTitle(title);
        Paper.Chars chars = paper.getChars();
        chars.setMonthly(Boolean.parseBoolean(monthly));
        chars.setGlance(Boolean.parseBoolean(glance));
        chars.setVolume(Integer.valueOf(volume));
        chars.setColor(Boolean.parseBoolean(color));

        if (!date.isEmpty()) {
            LocalDate localDate = LocalDate.parse(date);
            chars.setDateOfIssue(localDate);
        }

        PaperGenre pGenre = PaperGenre.resolveGenreByString(genre);
        chars.setGenre(pGenre);

        if (paper instanceof Magazine) {
            ((Magazine) paper).setIndex(index);
        } else if (paper instanceof Newspaper) {
            ((Newspaper) paper).setIndex(index);
        }

        return paper;
    }

    private static String getElementTextContent(final Element element,
                                                final String elementName) {
        LOGGER.trace("Getting element by element name - '{}'", elementName);
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node == null ? "" : node.getTextContent();
    }
}
