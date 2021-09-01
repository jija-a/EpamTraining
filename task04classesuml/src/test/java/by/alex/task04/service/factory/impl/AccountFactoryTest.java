package by.alex.task04.service.factory.impl;

import by.alex.task04.service.factory.WrongArgumentsException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountFactoryTest {

    private static final AccountFactory factory = new AccountFactory();

    @Test
    public void testThrowsExceptionWhileParametersIsNotValid() {
        assertThrows(WrongArgumentsException.class, factory::create);
        assertThrows(WrongArgumentsException.class, () -> factory.create(1, 2, 3));
        assertThrows(WrongArgumentsException.class, () -> factory.create("1", 0, new BigDecimal(1)));
        assertThrows(WrongArgumentsException.class, () -> factory.create(1, 2));
    }

}