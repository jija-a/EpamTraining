package task08.controller.command.impl;

import task08.controller.PageConstant;
import task08.controller.RequestConstant;
import task08.controller.command.Command;
import task08.dao.DaoException;
import task08.domain.Paper;
import task08.service.builder.xml.AbstractPaperBuilder;
import task08.service.builder.xml.PaperXMLBuilderFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Set;

public class UploadCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parsingType = req.getParameter(RequestConstant.PARSING_TYPE);
        Part filePart = req.getPart(RequestConstant.FILE);
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        AbstractPaperBuilder builder = PaperXMLBuilderFactory.createPaperBuilder(parsingType);

        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("data/" + fileName);

        File file = new File(url.getFile());
        String absolutePath = file.getAbsolutePath();

        Set<Paper> papers = null;
        try {
            builder.buildSetPapers(absolutePath);
            papers = builder.getPapers();
        } catch (DaoException e) {
            e.printStackTrace();
        }

        req.setAttribute(RequestConstant.PAPERS, papers);
        return PageConstant.RESULT_PAGE;
    }
}
