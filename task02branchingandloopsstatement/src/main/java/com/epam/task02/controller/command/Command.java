package com.epam.task02.controller.command;

import java.util.Map;

public interface Command {

    public abstract void execute(Map<String, Object> parameters);

}
