package by.alex.task03.context.impl;

import by.alex.task03.context.BaseEntityFileReader;
import by.alex.task03.service.ServiceFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ArrayFileReader implements BaseEntityFileReader {

    @Override
    public void read(String filePath) throws IOException {
        Scanner scanner = new Scanner(new File(filePath));
        if (!scanner.hasNextLine()) {
            throw new IllegalArgumentException("Non readable file");
        }

        scanner.nextLine();
        scanner.nextLine();
        scanner.nextLine();

        while (scanner.hasNext()) {
            String fileLine = scanner.next();
            String valuesSplit = fileLine.substring(1, fileLine.length() - 1);
            String[] valuesLine = valuesSplit.split(",", valuesSplit.length());

            double[] values;
            if (valuesSplit.length() == 1) {
                values = new double[]{Double.parseDouble(valuesLine[0])};
            } else {
                values = new double[valuesLine.length - 1];
                for (int i = 0; i < valuesLine.length - 1; i++) {
                    values[i] = Double.parseDouble(valuesLine[i]);
                }
            }

            ServiceFactory.getInstance().getArrayService().createArray(values);
        }
        scanner.close();
    }

}
