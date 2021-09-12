package dao.impl;

import domain.Matrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dao.EntityParser;
import service.InitializingException;
import service.factory.BaseEntityFactory;
import service.factory.WrongArgumentsException;
import service.factory.impl.MatrixFactory;

public class MatrixParserImpl implements EntityParser<Matrix> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixParserImpl.class);

    @Override
    public Matrix parse(String string) throws InitializingException {

        String[] fileLineSplit = string.split("\n", 2);
        String valuesString = fileLineSplit[1];
        String[] valuesSplit = valuesString.split("\n");
        String[] matrixValues = valuesSplit[0].split(" ");
        String matrixSize = String.valueOf(matrixValues.length);

        BaseEntityFactory<Matrix> factory = new MatrixFactory();
        try {
            return factory.create(matrixSize, matrixSize);
        } catch (WrongArgumentsException e) {
            LOGGER.error("Bad files");
            throw new InitializingException("Bad files");
        }

    }

}
