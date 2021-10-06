package by.alex.task08;

import by.alex.task08.dao.parser.xml.dom.PaperDOMBuilder;
import by.alex.task08.dao.parser.xml.sax.PaperSAXBuilder;
import by.alex.task08.dao.parser.xml.stax.PaperStAXBuilder;
import by.alex.task08.domain.Paper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String absolutePath = getAbsolutePath();
        Set<Paper> papers = runSAXBuilder(absolutePath);
        printPapers(papers);
    }

    private static Set<Paper> runStAXBuilder(String absolutePath) {
        PaperStAXBuilder stAXBuilder = new PaperStAXBuilder();
        stAXBuilder.buildSetPapers(absolutePath);
        return stAXBuilder.getPapers();
    }

    private static Set<Paper> runDOMBuilder(String absolutePath) {
        PaperDOMBuilder domBuilder = new PaperDOMBuilder();
        domBuilder.buildSetPapers(absolutePath);
        return domBuilder.getPapers();
    }

    private static Set<Paper> runSAXBuilder(String filePath) {
        PaperSAXBuilder builder = new PaperSAXBuilder();
        builder.buildSetPapers(filePath);
        return builder.getPapers();
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
