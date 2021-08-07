package com.epam.task01linear_algrorithms;

import com.epam.task01linear_algrorithms.util.MessageConstant;
import com.epam.task01linear_algrorithms.util.MessageManager;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {


        MessageManager.INSTANCE.changeLocale(new Locale("ru", "RU"));
        System.out.println("Русский: " + MessageManager.INSTANCE.getMessage(MessageConstant.MAIN_MENU));

        System.out.println("Сяут: Главное меню");

        MessageManager.INSTANCE.changeLocale(new Locale("en", "US"));
        System.out.println("Английский:" + MessageManager.INSTANCE.getMessage(MessageConstant.MAIN_MENU));

    }
}
