package by.alex.task03.context.impl;

import by.alex.task03.context.BaseEntityFileReader;
import by.alex.task03.domain.Matrix;
import by.alex.task03.service.ServiceFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MatrixFileReader implements BaseEntityFileReader {

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
            String[] fileLineSplit = fileLine.split(";", 3);
            int rows = Integer.parseInt(fileLineSplit[0]);
            int columns = Integer.parseInt(fileLineSplit[1]);

            String valuesSubstring = fileLineSplit[2].substring(1, fileLineSplit[2].length() - 1);
            String[] valuesLine = valuesSubstring.split(",", rows * columns);

            double[][] matrixValues = new double[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrixValues[i][j] = Double.parseDouble(valuesLine[i + j]);
                }
            }
            Matrix matrix = ServiceFactory.getInstance().getMatrixService().createMatrix(rows, columns);
            ServiceFactory.getInstance().getMatrixService().fillMatrixWithValues(matrix, matrixValues);
        }
        scanner.close();
    }

}
