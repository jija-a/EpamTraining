package by.alex.task03.dao.impl;

import by.alex.task03.dao.BaseEntityFileReader;
import by.alex.task03.domain.CustomArray;
import by.alex.task04.service.factory.impl.CustomArrayFactoryImpl;
import by.alex.task03.service.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ArrayFileReader implements BaseEntityFileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayFileReader.class);

    @Override
    public void read(String filePath) throws IOException {
        LOGGER.info("Reading arrays file");

        Scanner scanner = new Scanner(new File(filePath));
        if (!scanner.hasNextLine()) {
            LOGGER.error("Non readable arrays file");
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
                values = new double[valuesLine.length];
                for (int i = 0; i < valuesLine.length; i++) {
                    values[i] = Double.parseDouble(valuesLine[i]);
                }
            }

            CustomArray array = CustomArrayFactoryImpl.ENTITY_FACTORY.create(values.length);
            ServiceFactory.getInstance().getArrayService().fillArray(array, values);
        }

        scanner.close();
    }

}
