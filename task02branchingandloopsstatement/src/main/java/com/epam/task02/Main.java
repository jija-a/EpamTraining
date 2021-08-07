package com.epam.task02;

import com.epam.task02.context.Application;
import com.epam.task02.util.MessageConstant;
import com.epam.task02.util.MessageManager;

public class Main {

    public static void main(String[] args) {

        try {
            Application.run();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.MAIN_ERROR_FAILED_TO_START_APP));
        }

    }

}
