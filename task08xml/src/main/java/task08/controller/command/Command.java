package task08.controller.command;

import task08.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {

    String execute(HttpServletRequest req,
                   HttpServletResponse resp)
            throws ServiceException, ServletException, IOException;

}
