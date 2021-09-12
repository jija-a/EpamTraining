package service.factory.impl;

import domain.Limit;
import service.factory.BaseEntityFactory;
import service.factory.WrongArgumentsException;

public class LimitFactory implements BaseEntityFactory<Limit> {

    @Override
    public Limit create(Object... args) throws WrongArgumentsException {

        if (args.length != 2) {
            throw new WrongArgumentsException();
        }

        int lowerLimit = (int) args[0];
        int higherLimit = (int) args[1];

        return new Limit(lowerLimit, higherLimit);
    }

}
