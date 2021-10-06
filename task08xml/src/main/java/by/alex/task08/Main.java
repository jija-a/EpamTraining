package by.alex.task08;

import by.alex.task08.dao.DaoException;
import by.alex.task08.dao.parser.xml.AbstractPaperBuilder;
import by.alex.task08.dao.parser.xml.PaperXMLBuilderFactory;
import by.alex.task08.domain.Paper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.Set;

public class Main {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String absolutePath = getAbsolutePath();
        try {
            PaperXMLBuilderFactory factory = new PaperXMLBuilderFactory();
            AbstractPaperBuilder builder = factory.getPaperDOMBuilder();
            builder.buildSetPapers(absolutePath);

            Set<Paper> papers = builder.getPapers();
            printPapers(papers);
        } catch (DaoException e) {
            LOGGER.error("Dao exception: ", e);
        }
    }

    private static String getAbsolutePath() {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL url = classLoader.getResource("data/papers.xml");
        File file = new File(url.getFile());
        return file.getAbsolutePath();
    }

    private static void printPapers(Set<Paper> papers) {
        StringBuilder builder = new StringBuilder();
        for (Paper paper : papers) {
            builder.append(paper.toString()).append("\n");
        }
        String toPrint = builder.toString();
        LOGGER.info(toPrint);
    }
}
