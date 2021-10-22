package task08.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import task08.controller.command.Command;
import task08.controller.command.CommandFactory;
import task08.service.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/controller")
@MultipartConfig
public class Controller extends HttpServlet {

    public static final Controller CONTROLLER = new Controller();
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.handleRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("Handling request");

        String commandName = req.getParameter(RequestConstant.COMMAND);
        CommandFactory type = new CommandFactory();
        Command command = type.getCommand(commandName);

        String page;
        try {
            page = command.execute(req, resp);
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
