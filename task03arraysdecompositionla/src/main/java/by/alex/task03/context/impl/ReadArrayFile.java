package by.alex.task03.context.impl;

import by.alex.task03.context.ReadBaseEntityFile;
import by.alex.task03.service.ServiceFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadArrayFile implements ReadBaseEntityFile {

    @Override
    public void read(String filePath) throws IOException {
        Scanner scanner = new Scanner(new File(filePath));
        if (!scanner.hasNextLine()) throw new IllegalArgumentException("Non readable file");

        scanner.nextLine();
        scanner.nextLine();
        scanner.nextLine();

        while (scanner.hasNext()) {
            String fileLine = scanner.next();

            String valuesSplit = fileLine.substring(1, fileLine.length() - 1);

            String[] values = valuesSplit.split(",", valuesSplit.length());

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <= values.length - 1; i++) {
                list.add(Integer.valueOf(values[i]));
            }

            ServiceFactory.getInstance().getArrayService().fillFromFile(list);

        }
        scanner.close();
    }

}
