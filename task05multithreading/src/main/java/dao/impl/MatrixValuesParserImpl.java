package dao.impl;

import dao.EntityParser;

public class MatrixValuesParserImpl implements EntityParser<double[][]> {

    @Override
    public double[][] parse(String string) {

        String[] fileLineSplit = string.split("\n", 2);
        String valuesString = fileLineSplit[1];
        String[] valuesSplit = valuesString.split("\n");

        int n = valuesSplit.length;
        double[][] values = new double[valuesSplit.length][valuesSplit.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String[] valuesSplitString = valuesSplit[i].split(" ");
                values[i][j] = Double.parseDouble(valuesSplitString[j]);
            }
        }

        return values;
    }

}
