package com.epam.task02.controller.command;

import com.epam.task02.context.ViewResolver;

public interface Command {

    public abstract ViewResolver execute();

}
