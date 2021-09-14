package by.alex.task06.controller;

import by.alex.task06.service.ServiceException;

public interface Command {

    void execute() throws ServiceException;
}
