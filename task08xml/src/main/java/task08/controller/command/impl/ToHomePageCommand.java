package task08.controller.command.impl;

import task08.controller.PageConstant;
import task08.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToHomePageCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return PageConstant.HOME_PAGE;
    }
}
