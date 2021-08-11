package com.epam.task02.controller.command.impl;

import com.epam.task02.controller.command.Command;
import com.epam.task02.util.MessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class ChangeLocaleCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChangeLocaleCommand.class);

    private static final Locale en = new Locale("en", "US");
    private static final Locale ru = new Locale("ru", "RU");

    @Override
    public String execute() {
        LOGGER.info("executing changing locale command");

        if (MessageManager.INSTANCE.getLocale().equals(en)) {
            MessageManager.INSTANCE.changeLocale(ru);
        } else {
            MessageManager.INSTANCE.changeLocale(en);
        }

        return "locale changed";
    }

}
