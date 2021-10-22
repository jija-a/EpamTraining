package by.alex.task08.controller.command;

import by.alex.task08.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    String execute(HttpServletRequest req,
                   HttpServletResponse resp)
            throws ServiceException;

}
