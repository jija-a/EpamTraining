package by.alex.task08;

import by.alex.task08.dao.parser.xml.sax.PaperHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            PaperHandler handler = new PaperHandler();
            reader.setContentHandler(handler);
            String path = getAbsolutePath("data/papers.xml");
            reader.parse(path);
        } catch (ParserConfigurationException e) {
            LOGGER.error("Parser configuration error: ", e);
        } catch (SAXException e) {
            LOGGER.error("SAX parser error: ", e);
        } catch (IOException e) {
            LOGGER.error("IO Thread exception: ", e);
        }
    }

    private static String getAbsolutePath(String filePath) {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL url = classLoader.getResource(filePath);
        File file = new File(url.getFile());
        return file.getAbsolutePath();
    }
}
