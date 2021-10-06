package by.alex.task08;

import by.alex.task08.dao.parser.xml.dom.PaperDOMBuilder;
import by.alex.task08.dao.parser.xml.sax.PaperSAXBuilder;
import by.alex.task08.dao.parser.xml.stax.PaperStAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;

public class Main {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String absolutePath = getAbsolutePath();
        String papers;

        PaperSAXBuilder builder = new PaperSAXBuilder();
        builder.buildSetPapers(absolutePath);
        papers = builder.getPapers().toString();
        LOGGER.info(papers);

        //runCompleted(absolutePath);
    }

    private static String getAbsolutePath() {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL url = classLoader.getResource("data/papers.xml");
        File file = new File(url.getFile());
        return file.getAbsolutePath();
    }

    private static void runCompleted(String absolutePath) {
        String papers;

        PaperDOMBuilder domBuilder = new PaperDOMBuilder();
        domBuilder.buildSetPapers(absolutePath);
        papers = domBuilder.getPapers().toString();
        LOGGER.info(papers);

        PaperStAXBuilder stAXBuilder = new PaperStAXBuilder();
        stAXBuilder.buildSetPapers(absolutePath);
        papers = stAXBuilder.getPapers().toString();
        LOGGER.info(papers);
    }
}
