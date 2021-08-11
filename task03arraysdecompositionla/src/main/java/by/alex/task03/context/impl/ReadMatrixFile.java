package by.alex.task03.context.impl;

import by.alex.task03.context.ReadBaseEntityFile;
import by.alex.task03.domain.Matrix;
import by.alex.task03.service.ServiceFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadMatrixFile implements ReadBaseEntityFile {

    @Override
    public void read(String filePath) throws IOException {
        Scanner scanner = new Scanner(new File(filePath));
        if (!scanner.hasNextLine()) throw new IllegalArgumentException("Non readable file");

        scanner.nextLine();
        scanner.nextLine();
        scanner.nextLine();

        while (scanner.hasNext()) {
            String fileLine = scanner.next();
            String[] fileLineSplit = fileLine.split(";", 3);
            int rows = Integer.parseInt(fileLineSplit[0]);
            int columns = Integer.parseInt(fileLineSplit[1]);

            String valuesSplit = fileLineSplit[2].substring(1, fileLineSplit[2].length() - 1);

            String[] values = valuesSplit.split(",", rows * columns);

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <= values.length - 1; i++) {
                list.add(Integer.valueOf(values[i]));
            }

            Matrix matrix = ServiceFactory.getInstance().getMatrixService().createMatrix(rows, columns);
            ServiceFactory.getInstance().getMatrixService().fillFromFile(matrix, list);
        }
        scanner.close();
    }

}
