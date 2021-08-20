package by.alex.task03.dao.impl;

import by.alex.task03.dao.BaseEntityFileReader;
import by.alex.task03.domain.Matrix;
import by.alex.task03.domain.factory.impl.MatrixFactoryImpl;
import by.alex.task03.service.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MatrixFileReader implements BaseEntityFileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixFileReader.class);

    @Override
    public void read(String filePath) throws IOException {
        LOGGER.info("Reading matrix file");

        Scanner scanner = new Scanner(new File(filePath));
        if (!scanner.hasNextLine()) {
            LOGGER.error("Non readable matrix file");
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
            Matrix matrix = MatrixFactoryImpl.ENTITY_FACTORY.create(rows, columns);
            ServiceFactory.getInstance().getMatrixService().fillMatrixWithValues(matrix, matrixValues);
        }

        scanner.close();
    }

}
