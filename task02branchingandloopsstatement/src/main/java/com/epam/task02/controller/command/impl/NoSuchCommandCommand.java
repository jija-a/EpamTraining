package com.epam.task02.controller.command.impl;

import com.epam.task02.context.ViewResolver;
import com.epam.task02.controller.command.Command;

public class NoSuchCommandCommand implements Command {

    @Override
    public ViewResolver execute() {

        ViewResolver resolver = new ViewResolver();
        //todo
        resolver.setOutput("No such command");

        return resolver;
    }

}
