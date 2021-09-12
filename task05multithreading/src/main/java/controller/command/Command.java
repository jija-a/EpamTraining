package controller.command;

import service.ServiceException;

public interface Command {

    void execute() throws ServiceException;
}
