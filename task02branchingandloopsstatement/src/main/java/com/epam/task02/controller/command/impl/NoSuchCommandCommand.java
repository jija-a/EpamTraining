package com.epam.task02.controller.command.impl;

import com.epam.task02.controller.command.Command;
import com.epam.task02.util.MessageConstant;
import com.epam.task02.util.MessageManager;

public class NoSuchCommandCommand implements Command {

    @Override
    public String execute() {

        return MessageManager.INSTANCE.getMessage(MessageConstant.UNKNOWN_COMMAND);
    }

}
