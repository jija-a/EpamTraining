package by.alex.task08.dao.parser.xml.dom;

import by.alex.task08.domain.Booklet;
import by.alex.task08.domain.Paper;
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
import java.util.HashSet;
import java.util.Set;

public class PaperDOMBuilder {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PaperDOMBuilder.class);

    private final Set<Paper> papers;
    private DocumentBuilder docBuilder;

    public PaperDOMBuilder() {
        this.papers = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Parser config exception: ", e);
        }
    }

    public Set<Paper> getPapers() {
        return this.papers;
    }

    public void buildSetPapers(String fileName) {
        Document doc;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList papersList = root.getElementsByTagName("journal");
            for (int i = 0; i < papersList.getLength(); i++) {
                Element paperElement = (Element) papersList.item(i);
                Paper paper = buildPaper(paperElement);
                papers.add(paper);
            }
        } catch (IOException e) {
            LOGGER.error("File error or I/O error: ", e);
        } catch (SAXException e) {
            LOGGER.error("Parsing failure: ", e);
        }
    }

    private Paper buildPaper(Element paperElement) {
        Booklet paper = new Booklet();

        LOGGER.info("Setting 'paper' fields");
        paper.setId(Long.valueOf(paperElement.getAttribute("id")));
        paper.setTitle(getElementTextContent(
                paperElement, "title"));
        paper.setIndex(getElementTextContent(
                paperElement, "index"));
        Paper.Chars chars = paper.getChars();

        LOGGER.info("Setting 'Chars' fields");
        Element charsElement = (Element) paperElement.getElementsByTagName(
                "Chars").item(0);
        chars.setMonthly(Boolean.parseBoolean(getElementTextContent(charsElement, "monthly")));
        chars.setMonthly(Boolean.parseBoolean(getElementTextContent(charsElement, "glance")));
        chars.setMonthly(Boolean.parseBoolean(getElementTextContent(charsElement, "color")));
        chars.setVolume(Integer.valueOf(getElementTextContent(charsElement, "volume")));
        return paper;
    }

    private static String getElementTextContent(Element element, String elementName) {
        LOGGER.info("Getting element by element name - '{}'", elementName);
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
