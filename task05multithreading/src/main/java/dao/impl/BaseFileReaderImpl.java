package dao.impl;

import dao.BaseFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BaseFileReaderImpl implements BaseFileReader {

    @Override
    public String read(String filePath) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        }
    }

}
