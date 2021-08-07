package com.epam.task02.context;

import com.epam.task02.util.MessageConstant;
import com.epam.task02.util.MessageManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewResolver {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[] LETTERS = new String[]{"a", "b", "c", "d", "e", "f", "g"};

    private String output;

    public List<Double> getInput(int numbersQty) {
        List<Double> values = new ArrayList<>();

        for (int i = 0; i < numbersQty; i++) {
            System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.MAIN_PLEASE_INPUT) + " " + LETTERS[i]);
            values.add(SCANNER.nextDouble());
        }

        return values;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

}
