package com.epam.task02.controller.command.impl;

import com.epam.task02.controller.command.Command;
import com.epam.task02.util.MessageManager;

import java.util.Locale;
import java.util.Map;

public class ChangeLocaleCommand implements Command {

    private final Locale en = new Locale("en", "US");
    private final Locale ru = new Locale("ru", "RU");

    @Override
    public void execute(Map<String, Object> parameters) {

        if (MessageManager.INSTANCE.getLocale().equals(en)) {
            MessageManager.INSTANCE.changeLocale(ru);
        } else {
            MessageManager.INSTANCE.changeLocale(en);
        }

    }

}
