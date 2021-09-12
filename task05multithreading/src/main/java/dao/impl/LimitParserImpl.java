package dao.impl;

import dao.EntityParser;
import domain.Limit;
import service.factory.WrongArgumentsException;
import service.factory.impl.LimitFactory;

public class LimitParserImpl implements EntityParser<Limit> {

    private final LimitFactory factory;

    public LimitParserImpl() {
        this.factory = new LimitFactory();
    }

    @Override
    public Limit parse(String string) throws WrongArgumentsException {

        String[] fileLineSplit = string.split("\n", 2);

        String limitLine = fileLineSplit[0];
        String[] rowsColumnsSplit = limitLine.split(" ", 2);

        int lowerLimit = Integer.parseInt(rowsColumnsSplit[0]);
        int higherLimit = Integer.parseInt(rowsColumnsSplit[1].substring(0, 1));

        return factory.create(lowerLimit, higherLimit);
    }

}
